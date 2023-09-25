package p5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 20;
    static final int MIN = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        long[][] dp = new long[N + 1][MAX + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][nums[1]] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = MIN; j <= MAX; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j + nums[i] <= MAX) {
                        dp[i][j + nums[i]] += dp[i - 1][j];
                    }

                    if (j - nums[i] >= MIN) {
                        dp[i][j - nums[i]] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[N-1][nums[N]]);

    }
}
