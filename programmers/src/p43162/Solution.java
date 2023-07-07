package p43162;

import java.util.*;

class Solution {
    static List<Integer>[] network;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        network = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            network[i] = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if(i==j) continue;

                if(computers[i][j] == 1) {
                    network[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        return answer;
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : network[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
