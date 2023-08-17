package study.day6.p1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = (int)1e9;
    static int V, E, K;
    static ArrayList<Edge>[] graph;
    static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList();
        }

        distances = new int[V+1];
        Arrays.fill(distances, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
        }

        dijkstra();

        for (int i = 1; i < V+1; i++) {
            if(distances[i] == INF) System.out.println("INF");
            else System.out.println(distances[i]);
        }

    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(K, 0));
        distances[K] = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(distances[edge.to] >= edge.distance) {
                for (Edge next : graph[edge.to]) {
                    int distance = edge.distance + next.distance;

                    if(distances[next.to] > distance) {
                        distances[next.to] = distance;
                        pq.offer(new Edge(next.to, distance));
                    }
                }
            }
        }
    }

}

class Edge implements Comparable<Edge> {
    int to;
    int distance;

    public Edge(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        return distance - o.distance;
    }
}
