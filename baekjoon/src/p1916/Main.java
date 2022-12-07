package p1916;

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int node;
    int cost;
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}
public class Main {
    static int N, M;
    static int[] minCost;
    static ArrayList<Edge>[] graph;
    static final int INF = Integer.MAX_VALUE;

    static void dijkstra(int x){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(x, 0));
        minCost[x] = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(minCost[cur.node]>=cur.cost){
                for(Edge next:graph[cur.node]){
                    if(minCost[next.node] > cur.cost + next.cost){
                        minCost[next.node] = cur.cost + next.cost;
                        pq.offer(new Edge(next.node, minCost[next.node]));
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        minCost = new int[N+1];
        Arrays.fill(minCost, INF);

        StringTokenizer st;
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        dijkstra(from);

        System.out.println(minCost[to]);
    }
}
