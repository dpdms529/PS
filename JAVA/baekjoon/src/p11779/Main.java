package p11779;

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int node;
    int cost;
    ArrayList<Integer> history;

    public Edge(int node, int cost, ArrayList<Integer> history){
        this.node = node;
        this.cost = cost;
        this.history = history;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}

public class Main {
    static ArrayList<Edge>[] cities;
    static int[] minCosts;
    static final int INF = (int)1e9;

    static void dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0, new ArrayList<>(){{add(start);}}));
        minCosts[start] = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(cur.node == end){
                System.out.println(cur.cost);
                System.out.println(cur.history.size());
                for(int city : cur.history){
                    System.out.print(city + " ");
                }
                return;
            }
            if(minCosts[cur.node] >= cur.cost){
                for(Edge next : cities[cur.node]){
                    int cost = cur.cost + next.cost;
                    if(minCosts[next.node] > cost){
                        minCosts[next.node] = cost;
                        ArrayList<Integer> history = new ArrayList<>(cur.history);
                        history.add(next.node);
                        pq.offer(new Edge(next.node, cost, history));
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        cities = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            cities[i] = new ArrayList();
        }
        minCosts = new int[n+1];
        Arrays.fill(minCosts, INF);

        StringTokenizer st;
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cities[a].add(new Edge(b,c, new ArrayList<>()));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start, end);
    }
}
