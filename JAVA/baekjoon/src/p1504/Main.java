package p1504;

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
    public int compareTo(Edge o){
        return cost - o.cost;
    }
}

public class Main {
    static int N, E, V1, V2;
    static ArrayList<Edge>[] graph;
    static int costs[];
    static final int INF = 200000000;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        costs = new int[N+1];

        for(int i = 0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        int sum1 = dijkstra(1, V1) + dijkstra(V1, V2) + dijkstra(V2, N);
        int sum2 = dijkstra(1, V2) + dijkstra(V2, V1) + dijkstra(V1, N);
        int result = Math.min(sum1, sum2);

        System.out.println(result >= INF?-1:result);

    }

    public static int dijkstra(int start, int end){
        Arrays.fill(costs, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        costs[start] = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(costs[cur.node] >= cur.cost){
                for(Edge next : graph[cur.node]){
                    int cost = cur.cost + next.cost;
                    if(costs[next.node] > cost){
                        costs[next.node] = cost;
                        pq.offer(new Edge(next.node, cost));
                    }
                }
            }
        }
        return costs[end];
    }

}
