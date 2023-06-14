package 탐색.깊이우선탐색.p023;

import java.io.*;
import java.util.*;

/**
 * 연결 요소의 개수
 * https://www.acmicpc.net/problem/11724
 */
public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수
        N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);

        }

        int cnt = 0;
        for(int i = 1;i<=N;i++){
            if(!visited[i]){
                cnt++;
                bfs(i);

            }
        }

        System.out.println(cnt);
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }

            }
        }

    }
}
