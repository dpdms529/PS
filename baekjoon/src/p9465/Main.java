package p9465;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0;tc<T;tc++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];
            for(int i = 0;i<2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0;j<n;j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            for(int i = 0;i<n-1;i++){
                for(int j = 0;j<2;j++){
                    if(i<n-2) {
                        dp[j][i + 2] = Math.max(dp[j][i + 2], dp[j][i] + sticker[j][i + 2]);
                        dp[1-j][i + 2] = Math.max(dp[1-j][i + 2], dp[j][i] + sticker[1-j][i + 2]);
                    }
                    dp[1-j][i+1] = Math.max(dp[1-j][i+1], dp[j][i] + sticker[1-j][i+1]);
                }
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

        }

    }
}
