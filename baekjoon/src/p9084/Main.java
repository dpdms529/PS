package p9084;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N, M;
        int[] coins;
        int[][] dp;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<T;t++){
            N = Integer.parseInt(br.readLine());
            coins = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1;i<=N;i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[N+1][M+1];
            for(int i = 1;i<=N;i++){
                for(int j = 1;j<=M;j++){
                    if(coins[i]<=j){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - coins[i]] + coins[i]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            for(int i = 0;i<=N;i++){
                for(int j = 0;j<=M;j++){
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            sb.append(dp[N][M] + "\n");
        }
        System.out.println(sb);

    }
}
