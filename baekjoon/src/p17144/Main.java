package p17144;

import java.util.*;
import java.io.*;

public class Main {
    static int R, C, T;
    static int[][] room;
    static int airCleaner = -1;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        init();

        for(int i = 0;i<T;i++){
            getDustPosition();
            diffusion();
            airCleaning();
        }

        calculateTotalDust();

    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];

        for(int i = 0;i<R;i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0;j<C;j++){
                room[i][j] = Integer.parseInt(st.nextToken());

                if(room[i][j] == -1 && airCleaner == -1){
                    airCleaner = i;
                }
            }
        }

        br.close();
    }

    public static void getDustPosition(){
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                if(room[i][j] > 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
    }

    public static void diffusion(){
        int[][] move = new int[R][C];

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = 0;

            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny>=0 && nx>=0 && ny<R && nx<C && room[ny][nx] != -1){
                    move[ny][nx] += room[y][x] / 5;
                    cnt++;
                }
            }

            move[y][x] -= room[y][x] / 5 * cnt;
        }

        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                room[i][j] += move[i][j];
            }
        }
    }

    public static void airCleaning(){
        int prev = 0;

        for(int i = 1;i<C;i++){
            int tmp = room[airCleaner][i];
            room[airCleaner][i] = prev;
            prev = tmp;
        }

        if(airCleaner != 0){
            for(int i = airCleaner-1;i>=0;i--){
                int tmp = room[i][C-1];
                room[i][C-1] = prev;
                prev = tmp;
            }

            for(int i = C-2;i>0;i--){
                int tmp = room[0][i];
                room[0][i] = prev;
                prev = tmp;
            }

            for(int i = 0;i<airCleaner;i++){
                int tmp = room[i][0];
                room[i][0] = prev;
                prev = tmp;
            }
        }

        prev = 0;

        for(int i = 1;i<C;i++){
            int tmp = room[airCleaner+1][i];
            room[airCleaner+1][i] = prev;
            prev = tmp;
        }

        if(airCleaner != R-2){
            for(int i = airCleaner+2;i<R;i++){
                int tmp = room[i][C-1];
                room[i][C-1] = prev;
                prev = tmp;
            }

            for(int i = C-2;i>0;i--){
                int tmp = room[R-1][i];
                room[R-1][i] = prev;
                prev = tmp;
            }

            for(int i = R-1;i>airCleaner+1;i--){
                int tmp = room[i][0];
                room[i][0] = prev;
                prev = tmp;
            }
        }
    }

    public static void calculateTotalDust(){
        int sum = 0;

        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                sum += room[i][j];
            }
        }

        System.out.println(sum+2);
    }
}
