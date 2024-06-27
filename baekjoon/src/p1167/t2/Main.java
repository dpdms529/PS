package p1167.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int max = 0;
    static int node = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int idx, dist;

            while((idx = Integer.parseInt(st.nextToken())) != -1) {
                dist = Integer.parseInt(st.nextToken());
                graph[v].add(new Node(idx, dist));
            }
        }

        visited = new boolean[V+1];
        dfs(1, 0);

        visited = new boolean[V+1];
        dfs(node, 0);

        System.out.println(max);
    }

    static void dfs(int idx, int dist) {
        visited[idx] = true;

        if(dist > max) {
            max = dist;
            node = idx;
        }

        for(Node next : graph[idx]) {
            int nextDist = dist + next.dist;

            if(!visited[next.idx]) {
                dfs(next.idx, nextDist);
            }
        }
    }

}

class Node {
    int idx;
    int dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}
