package study.day7.p2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] numbers;
    static long[] tree;

    static int S = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new long[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        init();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c  = Long.parseLong(st.nextToken());
                long diff = c - query(1, S, 1, b, b);
                update(1, S, 1, b, diff);
            } else if (a == 2) {
                int c = Integer.parseInt(st.nextToken());
                System.out.println(query(1, S, 1, b, c));
            }
        }
    }

    static void init() {
        while (S < N) {
            S *= 2;
        }

        tree = new long[2 * S];

        for (int i = 0; i < N; i++) {
            tree[i + S] = numbers[i];
        }

        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long query(int left, int right, int node, int start, int end) {
        if (left > end || right < start) return 0;
        else if (start <= left && right <= end) return tree[node];
        else {
            int mid = (left + right) / 2;
            long leftResult = query(left, mid, node * 2, start, end);
            long rightResult = query(mid + 1, right, node * 2 + 1, start, end);
            return leftResult + rightResult;
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (left <= target && target <= right) {
            tree[node] += diff;

            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}
