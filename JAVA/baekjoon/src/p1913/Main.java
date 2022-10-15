package p1913;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int m = n/2;
        arr[m][m] = 1;
        int move = 1;
        int num = 2;
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
        int dir = 0;
        int y = m;
        int x = m;
        int y_find = m+1, x_find = m+1;
        loop: while(true){
            for(int i = 0;i<2;i++){
                for(int j = 0;j<move;j++){
                    y += dy[dir];
                    x += dx[dir];
                    arr[y][x] = num++;
                    if(arr[y][x] == find){
                        y_find = y+1;
                        x_find = x+1;
                    }
                    if(num > n*n) break loop;
                }
                dir++;
                if(dir==4) dir = 0;
            }
            move++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write(y_find + " " + x_find);
        bw.flush();
        bw.close();
        br.close();
    }
}
