package p1256.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[201][201];
    static StringBuilder sb = new StringBuilder();
    static final int MAX = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(combination(N+M, M) < K) sb.append(-1);
        else query(N, M, K);

        System.out.println(sb);
    }

    static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        else if (dp[n][r] != 0) return dp[n][r];
        else return dp[n][r] = Math.min(MAX, combination(n - 1, r - 1) + combination(n - 1, r));
    }

    static void query(int n, int m, int k) {
        if(n+m == 0) return;

        if (n == 0) {
            sb.append("z");
            query(n, m - 1, k);
        } else if (m == 0) {
            sb.append("a");
            query(n - 1, m, k);
        } else {
            int count = combination(n + m - 1, m);

            if (count >= k) {
                sb.append("a");
                query(n - 1, m, k);
            } else {
                sb.append("z");
                query(n, m - 1, k - count);
            }
        }
    }
}
