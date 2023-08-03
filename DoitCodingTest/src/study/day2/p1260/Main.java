package study.day2.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N + 1; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);

    }

    static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx + " ");

        for (Integer next : graph[idx]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(idx);
        visited[idx] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur + " ");

            for (Integer next : graph[cur]) {
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
