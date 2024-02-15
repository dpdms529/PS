package p1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int test = 0; test < K; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            visited = new int[V+1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);

            }

            boolean result = true;

            for (int i = 1; i <= V; i++) {
                if(visited[i] == 0) {
                    result = bfs(i);
                    if(!result) break;
                }
            }
            System.out.println(result?"YES":"NO");

        }

    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer next : graph[cur]) {
                if(visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = -visited[cur];
                }else if(visited[next] == visited[cur]) return false;
            }
        }
        return true;
    }
}
