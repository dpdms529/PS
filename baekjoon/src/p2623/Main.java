package p2623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        indegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n-1; j++) {
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                indegree[b]++;
                a = b;
            }
        }

        topologicalSort();

        if(list.size() < N) {
            System.out.println(0);
        } else {
            for (Integer item : list) {
                System.out.println(item);
            }
        }

    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : graph[cur]) {
                indegree[next]--;

                if(indegree[next] == 0) queue.offer(next);
            }

            list.add(cur);
        }
    }
}
