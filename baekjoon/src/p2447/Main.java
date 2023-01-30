package p2447;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] stars;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N];

        for(int i = 0;i<N;i++){
            Arrays.fill(stars[i], ' ');
        }

        drawStar(0,0, N);

        printStars(N);
    }

    public static void drawStar(int row, int col, int n){
        if(n==3){
            for(int i = 0;i<3;i++){
                stars[row][col+i] = '*';
                stars[row+2][col+i] = '*';
            }

            stars[row+1][col] = '*';
            stars[row+1][col+2] = '*';
        }else{
            n /= 3;

            for(int i = 0;i<n*3;i+=n){
                for(int j = 0;j<n*3;j+=n){
                    if(i == n && j == n) continue;

                    drawStar(row+i, col+j, n);
                }
            }
        }
    }

    public static void printStars(int n){
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
