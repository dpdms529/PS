package Search.DFS_BFS.p1260;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int x){
        visited[x] = true;
        sb.append(x + " ");
        for(int next : graph[x]){
            if(!visited[next]) dfs(next);
        }
    }

    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node + " ");
            for(int next : graph[node]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N : 정점 개수, M : 간선 개수, V : 시작 정점
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList();
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1;i<=N;i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);

    }
}
