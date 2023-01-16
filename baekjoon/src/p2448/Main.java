package p2448;

import java.util.*;
import java.io.*;

public class Main {
    static char[][] stars;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stars = new char[n][2*n-1];

        for(int i = 0;i<n;i++){
            Arrays.fill(stars[i], ' ');
        }

        draw(0, n-1, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n*2-1;j++){
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void draw(int row, int col, int n){
        if(n==3){
            stars[row][col] = '*';
            stars[row+1][col-1] = '*';
            stars[row+1][col+1] = '*';
            for(int i = -2;i<=2;i++){
                stars[row+2][col+i] = '*';
            }
        }else{
            n /= 2;
            draw(row, col, n);
            draw(row + n, col - n, n);
            draw(row + n, col + n, n);
        }
    }
}
