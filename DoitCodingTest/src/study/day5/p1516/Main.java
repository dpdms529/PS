package study.day5.p1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Building>[] graph;
    static int[] indegree;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        times = new int[N + 1];

        indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            Building building = new Building(i, times[i]);

            int next = Integer.parseInt(st.nextToken());

            while (next != -1) {
                graph[next].add(building);
                indegree[i]++;
                next = Integer.parseInt(st.nextToken());
            }
        }

        topologicalSort();
    }

    static void topologicalSort() {
        Queue<Building> queue = new LinkedList<>();
        int[] result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(new Building(i, times[i]));
            }
        }

        while (!queue.isEmpty()) {
            Building cur = queue.poll();

            for (Building next : graph[cur.idx]) {
                indegree[next.idx]--;
                next.time = Math.max(next.time, cur.time + times[next.idx]);

                if (indegree[next.idx] == 0) {
                    queue.offer(next);
                }
            }

            result[cur.idx] = cur.time;
        }

        for (int i = 1; i <= N ; i++) {
            System.out.println(result[i]);
        }

    }
}

class Building {
    int idx;
    int time;

    public Building(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }
}
