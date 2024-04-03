package p1238.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static int[][] minCost;
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
        }

        minCost = new int[2][N+1];
        Arrays.fill(minCost[0], INF);

        dijkstra(X, 0);

        int max = 0;

        for (int i = 1; i <= N; i++) {
            Arrays.fill(minCost[1], INF);
            dijkstra(i, 1);
            max = Math.max(max, minCost[0][i] + minCost[1][X]);
        }

        System.out.println(max);

    }

    static void dijkstra(int destination, int direction) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(destination, 0));
        minCost[direction][destination] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.cost <= minCost[direction][cur.node]) {
                for (Node next : graph[cur.node]) {
                    int cost = cur.cost + next.cost;

                    if(cost < minCost[direction][next.node]) {
                        pq.offer(new Node(next.node, cost));
                        minCost[direction][next.node] = cost;
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}
