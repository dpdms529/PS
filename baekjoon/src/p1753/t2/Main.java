package p1753.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) sb.append("INF" + "\n");
            else sb.append(distance[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));
        distance[K] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if(distance[node.to] >= node.dist) {
                for (Node next : graph[node.to]) {
                    int sum = node.dist + next.dist;

                    if(distance[next.to] > sum) {
                        distance[next.to] = sum;
                        pq.offer(new Node(next.to, sum));
                    }
                }
            }

        }
    }
}

class Node implements Comparable<Node> {
    int to;
    int dist;

    public Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return dist - o.dist;
    }
}