package Day10.p7579;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N];
        int[] cost = new int[N];
        int[][] dp;
        int totalCost = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            cost[i] = Integer.parseInt(st.nextToken());
            totalCost += cost[i];
        }

        dp = new int[N+1][totalCost+1];
        for(int i = 1;i<=N;i++){
            for(int j = 0;j<=totalCost;j++){
                dp[i][j] = dp[i-1][j];
                if(j-cost[i-1] >= 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i-1]] + memory[i-1]);
            }
        }

        int answer = -1;
        for(int i = 0;i<=totalCost;i++){
            if(dp[N][i]>=M){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
