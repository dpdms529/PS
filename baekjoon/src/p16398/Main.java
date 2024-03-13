package p16398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                long cost = Long.parseLong(st.nextToken());

                if(i == j) continue;

                pq.offer(new Edge(i, j, cost));

            }
        }

        System.out.println(kruskal());

    }

    static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    static long kruskal() {
        int cnt = 0;
        long sum = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(find(cur.from) != find(cur.to)) {
                union(cur.from, cur.to);
                cnt++;
                sum += cur.cost;
            }

            if(cnt == N-1) break;
        }

        return sum;
    }
}

class Edge implements Comparable<Edge>{
    int from;
    int to;
    long cost;

    public Edge(int from, int to, long cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(cost, o.cost);
    }
}
