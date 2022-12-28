package Day07.p11657;

import java.util.*;
import java.io.*;

class Edge{
    int from;
    int to;
    int dist;
    public Edge(int from, int to, int dist){
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edgeArray = new Edge[M];
        long[] distance = new long[N+1];
        long INF = Long.MAX_VALUE;

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeArray[i] = new Edge(a, b, c);
        }

        Arrays.fill(distance, INF);

        distance[1] = 0;
        boolean flag = false;
        for(int i = 1;i<=N;i++){
            for(int j = 0;j<M;j++){
                Edge edge = edgeArray[j];
                if(distance[edge.from] != INF){
                    if(distance[edge.to] > distance[edge.from] + edge.dist){
                        if(i == N) flag = true;
                        distance[edge.to]  = distance[edge.from] + edge.dist;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(flag) sb.append(-1);
        else{
            for(int i = 2;i<=N;i++){
                if(distance[i]==INF) sb.append(-1 + "\n");
                else sb.append(distance[i] + "\n");
            }
        }
        System.out.println(sb);
    }
}
