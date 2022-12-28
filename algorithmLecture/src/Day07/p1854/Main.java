package Day07.p1854;

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
    static int n, m, k;
    static ArrayList<Edge>[] graph;
    static ArrayList<Integer>[] distance;

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        int doneCnt = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(distance[cur.node].size() < k) {
                distance[cur.node].add(cur.dist);
                if(distance[cur.node].size()==k) doneCnt++;
                if (doneCnt == n) break;
                for(Edge next : graph[cur.node]){
                    if(distance[next.node].size() < k){
                        pq.offer(new Edge(next.node, cur.dist + next.dist));
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        distance = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<>();
            distance[i] = new ArrayList();
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b,c));
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            if(distance[i].size()==k) sb.append(distance[i].get(k-1) + "\n");
            else sb.append(-1 + "\n");
        }
        System.out.println(sb);
    }
}
