package Day06.p1922;

import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;
    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {
    static int N, M;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;

    static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        parent[find(a)] = find(b);
    }

    static void kruskal(){
        int sum = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(find(edge.from)!=find(edge.to)){
                union(edge.from, edge.to);
                sum += edge.cost;
                cnt++;
            }
            if(cnt==N-1) break;
        }
        System.out.println(sum);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i = 1;i<=N;i++){
            parent[i] = i;
        }

        for(int i = 0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a,b,c));
        }

        kruskal();
    }
}
