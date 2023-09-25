package study.day8.p11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][N+1];
        for (int i = 0; i < N+1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < K+1; i++) {
            for (int j = i; j < N+1; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i][j-1]) % 10007;
            }
        }

        System.out.println(dp[K][N]);
    }
}
