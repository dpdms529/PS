package p1368;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int totalCost = 0;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            pq.offer(new Edge(i, 0, Integer.parseInt(br.readLine())));
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());

                if(i != j) {
                    pq.offer(new Edge(i, j, cost));
                }
            }
        }

        kruskal();
        System.out.println(totalCost);

    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        parents[find(b)] = find(a);
    }

    static void kruskal() {
        int cnt = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(find(cur.from) != find(cur.to)) {
                union(cur.from, cur.to);
                totalCost += cur.cost;
                cnt++;
            }

            if(cnt == N) {
                break;
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(cost, o.cost);
    }
}
