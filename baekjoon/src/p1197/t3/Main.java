package p1197.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parents;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.offer(new Node(A, B, C));

        }

        kruskal();

    }

    public static void kruskal() {
        int cnt = 0;
        long sum = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(find(cur.from) != find(cur.to)) {
                union(cur.from, cur.to);
                cnt++;
                sum += cur.cost;
            }

            if(cnt == V-1) break;
        }

        System.out.println(sum);
    }

    public static void init() {
        parents = new int[V+1];

        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }
    }

    public static void union(int a, int b) {
        parents[find(b)] = find(a);
    }

    public static int find(int x) {
        if(parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}
