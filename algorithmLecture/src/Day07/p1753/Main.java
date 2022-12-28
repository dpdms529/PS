package Day07.p1753;

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int node;
    int dist;
    public Edge(int node, int dist){
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
}

public class Main {
    static int V, E, K;
    static ArrayList<Edge>[] graph;
    static int[] distance;

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(K, 0));
        distance[K] = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(distance[edge.node]>=edge.dist){
                for(Edge next : graph[edge.node]){
                    if(distance[next.node] > edge.dist + next.dist){
                        distance[next.node] = edge.dist + next.dist;
                        pq.offer(new Edge(next.node, distance[next.node]));
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        distance = new int[V+1];

        for(int i = 1;i<=V;i++){
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=V;i++){
            if(distance[i] == Integer.MAX_VALUE) sb.append("INF" + "\n");
            else sb.append(distance[i] + "\n");
        }
        System.out.println(sb);

    }
}
