package 탐색.너비우선탐색.p026;

import java.io.*;
import java.util.*;

/**
 * DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class Main {
    //N : 정점의 개수, M : 간선의 개수, V : 탐색 시작 정점
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graphInit(br);

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);

    }

    private static void graphInit(BufferedReader br) throws IOException {
        StringTokenizer st;
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
    }

    static void dfs(int num){
        visited[num] = true;
        sb.append(num + " ");

        for (int next : graph[num]) {
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        visited[num] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur + " ");

            for(int next : graph[cur]){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
