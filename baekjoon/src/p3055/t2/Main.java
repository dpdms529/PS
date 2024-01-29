package p3055.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] graph;
    static int[][] visited;
    static Queue<Node> queue = new LinkedList<>();
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};
    static final int EMPTY = 0;
    static final int WATER = -1;
    static final int STONE = -2;
    static final int HEDGEHOG = 1;
    static final int BEAVER = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], -1);
        }

        int startY = 0;
        int startX = 0;
        int endY = 0;
        int endX = 0;

        for (int i = 0; i < R; i++) {
            String row = br.readLine();

            for (int j = 0; j < C; j++) {
                if (row.charAt(j) == '.') {
                    graph[i][j] = EMPTY;
                } else if (row.charAt(j) == '*') {
                    graph[i][j] = WATER;
                    queue.offer(new Node(i, j, false));
                } else if (row.charAt(j) == 'X') {
                    graph[i][j] = STONE;
                } else if (row.charAt(j) == 'D') {
                    graph[i][j] = BEAVER;
                    endY = i;
                    endX = j;
                } else if (row.charAt(j) == 'S') {
                    graph[i][j] = HEDGEHOG;
                    startY = i;
                    startX = j;
                }
            }
        }

        bfs(startY, startX);

        System.out.println(visited[endY][endX] == -1 ? "KAKTUS" : visited[endY][endX]);
    }

    static void bfs(int y, int x) {
        queue.offer(new Node(y, x, true));
        visited[y][x] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny >= 0 && ny < R && nx >= 0 && nx < C && visited[ny][nx] == -1 && graph[ny][nx] >= WATER) {
                    if(cur.isHedgehog) {
                        graph[ny][nx] = HEDGEHOG;
                        queue.offer(new Node(ny, nx, true));
                        visited[ny][nx] = visited[cur.y][cur.x] + 1;
                    }

                    if(!cur.isHedgehog && graph[ny][nx] != BEAVER) {
                        graph[ny][nx] = WATER;
                        queue.offer(new Node(ny, nx, false));
                    }
                }
            }
        }
    }

}

class Node {
    int y;
    int x;
    boolean isHedgehog;

    public Node(int y, int x, boolean isHedgehog) {
        this.y = y;
        this.x = x;
        this.isHedgehog = isHedgehog;
    }
}
