package p2293;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k+1];

        for(int i = 0;i<n;i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<=k;j++){
                if(j >= coins[i])  dp[j] += dp[j-coins[i]];
            }
        }

        System.out.println(dp[k]);

    }
}
