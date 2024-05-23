package p1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N, M, K;
    static int[][] graph;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visited = new boolean[N][M];

            ArrayList<int[]> cabbages = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
                cabbages.add(new int[]{y, x});

            }

            int cnt = 0;

            for (int[] cabbage : cabbages) {
                int y = cabbage[0];
                int x = cabbage[1];

                if (!visited[y][x]) {
                    bfs(y, x);
                    cnt++;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        }

    }

    static void bfs(int y, int x) {
        int[] start = new int[]{y, x};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && graph[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }

    }
}
