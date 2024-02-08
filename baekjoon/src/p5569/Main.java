package p5569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][][] dp = new int[w][h][2][2];

        for (int i = 1; i < w; i++) {
            dp[i][0][0][1] = 1;
        }

        for (int i = 1; i < h; i++) {
            dp[0][i][1][1] = 1;
        }

        for (int y = 1; y < w; y++) {
            for (int x = 1; x < h; x++) {
                dp[y][x][0][0] = dp[y-1][x][1][1];
                dp[y][x][0][1] = (dp[y-1][x][0][0] + dp[y-1][x][0][1]) % 100000;
                dp[y][x][1][0] = dp[y][x-1][0][1];
                dp[y][x][1][1] = (dp[y][x-1][1][0] + dp[y][x-1][1][1]) % 100000;
            }
        }

        int result = (dp[w-1][h-1][0][0] + dp[w-1][h-1][0][1] + dp[w-1][h-1][1][0] + dp[w-1][h-1][1][1]) % 100000;
        System.out.println(result);
    }

}
