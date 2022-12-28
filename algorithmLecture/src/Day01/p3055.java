package Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3055 {
    public static int r,c;
    public static int[][] graph;
    public static int[][] cnt;
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};
    public static Queue<int[]> queue = new LinkedList<>();

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];
            int b = pos[2];
            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny>=0 && ny<r && nx>=0 && nx<c){
                    if(b==0 && graph[ny][nx]<1){
                        graph[ny][nx] = 1;
                        queue.offer(new int[]{ny,nx,0});
                    }else if(b==1 && (graph[ny][nx]==0 || graph[ny][nx]==3)){
                        graph[ny][nx] = -1;
                        cnt[ny][nx] = cnt[y][x] + 1;
                        queue.offer(new int[]{ny,nx,1});
                    }
                }
            }
        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new int[r][c];
        cnt = new int[r][c];
        int[] start = new int[3];
        int[] end = new int[2];

        for(int i = 0;i<r;i++){
            String tmp = br.readLine();
            for(int j = 0;j<c;j++){
                switch (tmp.charAt(j)){
                    case '.':
                        graph[i][j] = 0;
                        break;
                    case '*':
                        graph[i][j] = 1;
                        queue.offer(new int[]{i,j,0});
                        break;
                    case 'X':
                        graph[i][j] = 2;
                        break;
                    case 'D':
                        graph[i][j] = 3;
                        end[0] = i;
                        end[1] = j;
                        break;
                    case 'S':
                        graph[i][j] = -1;
                        start[0] = i;
                        start[1] = j;
                        start[2] = 1;
                        break;
                }
            }
        }
        queue.offer(start);
        bfs();
        int result = cnt[end[0]][end[1]];
        if(result==0) System.out.println("KAKTUS");
        else System.out.println(result);
    }
}
