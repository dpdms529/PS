package p2589;

import java.util.*;
import java.io.*;

public class Main {
    static int row, col;
    static char[][] map;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];

        for(int i = 0;i<row;i++){
            String s = br.readLine();

            for(int j = 0;j<col;j++){
                map[i][j] = s.charAt(j);
            }
        }

        int result = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(map[i][j] == 'L'){
                    result = Math.max(result, bfs(i, j));
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(int y, int x){
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        queue.offer(new int[]{y, x, 0});
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            y = cur[0];
            x = cur[1];
            time = cur[2];

            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny>=0 && ny<row && nx>=0 && nx<col && map[ny][nx] == 'L' && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny,nx, time+1});
                }
            }
        }

        return time;
    }
}
