package p1753;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    private int index;
    private int distance;
    public Node(int index, int cost){
        this.index = index;
        this.distance = cost;
    }
    public int getIndex(){
        return index;
    }
    public int getDistance(){
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.getDistance();
    }
}

public class p1753 {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] dist;

    public static void dijkstra(int k){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k,0));
        dist[k] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int current = node.getIndex();
            int distance = node.getDistance();
            if(dist[current]<distance) continue;
            for(int i = 0;i<graph.get(current).size();i++){
                int cost = dist[current] + graph.get(current).get(i).getDistance();
                if(cost<dist[graph.get(current).get(i).getIndex()]){
                    dist[graph.get(current).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(current).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        for(int i = 0;i<n+1;i++){
            graph.add(new ArrayList<Node>());
        }
        dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        dijkstra(k);

        for(int i = 1;i<n+1;i++){
            if(dist[i] == (int)1e9) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
