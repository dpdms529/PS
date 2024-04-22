package p11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int MAX = 501;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] R = new int[N+1];
        int[] C = new int[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[MAX][MAX];

        for (int i = 0; i < N - 1; i++) {
            dp[i][i+1] = R[i] * R[i+1] * C[i+1];
        }

        for (int gap = 2; gap < N; gap++) {
            for (int left = 0; left < N - gap; left++) {
                int right = left + gap;

                for (int m = left; m < right; m++) {
                    int res = dp[left][m] + dp[m+1][right] + R[left] * C[m] * C[right];

                    if(dp[left][right] == 0 || dp[left][right] > res) {
                        dp[left][right] = res;
                    }
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}
