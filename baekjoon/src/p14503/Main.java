package p14503;

import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dy = {0,-1,0,1};
    static int[] dx = {-1,0,1,0};
    static int[] left = {3,0,1,2};
    static boolean[][] cleaned;
    static int cleanedArea = 0;

    static void clean(int y, int x, int d, int turn){
        if(!cleaned[y][x]){
            cleaned[y][x] = true;
            cleanedArea++;
            turn = 0;
        }
        if(turn==4){
            switch (d){
                case 0:
                    y+=1;
                    break;
                case 1:
                    x-=1;
                    break;
                case 2:
                    y-=1;
                    break;
                case 3:
                    x+=1;
                    break;
            }
            if(map[y][x]==0) clean(y,x,d,0);
            return;
        }
        int ny = y + dy[d];
        int nx = x + dx[d];
        int nd = left[d];
        if(map[ny][nx]==0 && !cleaned[ny][nx]){
            clean(ny,nx,nd,turn+1);
        }else if(map[ny][nx]==1 || cleaned[ny][nx]){
            clean(y,x,nd,turn+1);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cleaned = new boolean[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r,c,d,0);
        System.out.println(cleanedArea);
    }
}
