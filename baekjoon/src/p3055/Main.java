package p3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final char WATER = '*';
    static final char EMPTY = '.';
    static final char STONE = 'X';
    static final char BEAVER = 'D';
    static final char HEDGEHOG = 'S';
    static final int[] DX = {0, 0, 1, -1};
    static final int[] DY = {-1, 1, 0, 0};
    static int R, C;
    static char[][] graph;
    static int[][] time;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        time = new int[R][C];

        int[] hedgehog = new int[3];
        int[] beaver = new int[2];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = row.charAt(j);
                if(graph[i][j] == HEDGEHOG) {
                    hedgehog[0] = i;
                    hedgehog[1] = j;
                    hedgehog[2] = 0;
                } else if (graph[i][j] == WATER) {
                    queue.offer(new int[]{i, j, 1});
                } else if(graph[i][j] == BEAVER) {
                    beaver[0] = i;
                    beaver[1] = j;
                }
            }
        }

        queue.offer(hedgehog);

        bfs();

        if (time[beaver[0]][beaver[1]] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(time[beaver[0]][beaver[1]]);
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int isWater = cur[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + DY[i];
                int nx = x + DX[i];

                if (ny >= 0 && nx >= 0 && ny < R && nx < C && graph[ny][nx] != STONE && graph[ny][nx] != WATER) {
                    if (isWater == 1 && graph[ny][nx] != BEAVER) {
                        graph[ny][nx] = WATER;
                        queue.offer(new int[]{ny, nx, 1});
                    }

                    if (isWater == 0 && (graph[ny][nx] == EMPTY || graph[ny][nx] == BEAVER)) {
                        graph[ny][nx] = HEDGEHOG;
                        time[ny][nx] = time[y][x] + 1;
                        queue.offer(new int[]{ny, nx, 0});
                    }
                }
            }
        }
    }
}
