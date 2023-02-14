package p14938;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r;
    static int[] items;
    static ArrayList<Edge>[] graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        graph = new ArrayList[n+1];
        distance = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1;i<=n;i++){
            items[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for(int i = 0;i<r;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, l));
            graph[b].add(new Edge(a, l));
        }

        int result = 0;

        for(int i = 1;i<=n;i++){
            dijkstra(i);

            int sum = 0;

            for(int j = 1;j<=n;j++){
                if(distance[j] < Integer.MAX_VALUE){
                    sum += items[j];
                }
            }

            result = Math.max(result, sum);
        }

        System.out.println(result);
    }

    static void dijkstra(int start){
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(distance[cur.node] >= cur.dist){
                for(Edge next : graph[cur.node]){
                    int nextDist = cur.dist + next.dist;

                    if(nextDist <= m && distance[next.node] > nextDist){
                        distance[next.node] = nextDist;
                        pq.offer(new Edge(next.node, nextDist));
                    }
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>{

    int node;
    int dist;

    Edge(int node, int dist){
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge o) {
        return dist - o.dist;
    }
}
