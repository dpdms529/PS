package p1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);

        int result = dfs(len, 0, 0, 0);
        System.out.println(result);
    }

    static int dfs(int len, int y, int x, int value) {
        if (len == 1) {
            return value;
        }

        len /= 2;
        int startY = y;
        int midY = y + len;
        int endY = y + len * 2;
        int startX = x;
        int midX = x + len;
        int endX = x + len * 2;
        int area = len * len;

        if (startY <= r && r < midY && startX <= c &&  c < midX) {
            return dfs(len, y, x, value);
        } else if (startY <= r && r < midY && midX <= c &&  c < endX) {
            return dfs(len, y, x + len, value + area);
        } else if (midY <= r && r < endY && startX <= c &&  c < midX) {
            return dfs(len, y + len, x, value + area * 2);
        } else if (midY <= r && r < endY && midX <= c &&  c < endX) {
            return dfs(len, y + len, x + len, value + area * 3);
        }

        return 0;
    }
}

