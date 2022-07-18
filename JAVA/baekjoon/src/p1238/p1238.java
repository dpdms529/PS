package p1238;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    private int index;
    private int distance;
    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
    public int getIndex(){return index;}
    public int getDistance(){return distance;};

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}

public class p1238 {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] toParty;
    public static int[] toHome;

    public static void dijkstra(int x, boolean party){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(x, 0));
        int[] dist;
        if(party) dist = toParty;
        else dist = toHome;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.getIndex();
            int dis = node.getDistance();
            if(dist[cur]<dis) continue;
            for(int i = 0;i<graph.get(cur).size();i++){
                int cost = dis + graph.get(cur).get(i).getDistance();
                if(cost < dist[graph.get(cur).get(i).getIndex()]){
                    dist[graph.get(cur).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(cur).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] cost = new int[n+1];

        for(int i = 0;i<n+1;i++){
            graph.add(new ArrayList<Node>());
        }
        toHome = new int[n+1];
        toParty = new int[n+1];
        Arrays.fill(toHome, (int)1e9);
        Arrays.fill(toParty, (int)1e9);

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
        }

        dijkstra(x, false);

        for(int i = 1;i<n+1;i++){
            dijkstra(i, true);
            cost[i] = toHome[i] + toParty[x];
            Arrays.fill(toParty, (int)1e9);
        }

        int max = 0;
        for(int i = 1;i<n+1;i++){
            if(cost[i] > max) max = cost[i];
        }
        System.out.println(max);

    }
}
