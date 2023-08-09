package p2042.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //수의 개수
        int N = Integer.parseInt(st.nextToken());
        //수의 변경이 일어나는 횟수
        int M = Integer.parseInt(st.nextToken());
        //구간의 합을 구하는 횟수
        int K = Integer.parseInt(st.nextToken());

        long[] nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        int s = 1;
        while (s < N) {
            s *= 2;
        }
        tree = new long[2 * s];

        for (int i = 0; i < N; i++) {
            tree[s + i] = nums[i];
        }

        for (int i = s - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                long diff = c - query(1, s, 1, b, b);
                update(1, s, 1, b, diff);
            } else if (a == 2) {
                int c = Integer.parseInt(st.nextToken());
                System.out.println(query(1, s, 1, b, c));
            }
        }

    }

    static long query(int left, int right, int node, int start, int end) {
        if (start > right || end < left) return 0;
        else if (start <= left && end >= right) return tree[node];
        else {
            int mid = (left + right) / 2;
            long leftResult = query(left, mid, node * 2, start, end);
            long rightResult = query(mid + 1, right, node * 2 + 1, start, end);
            return leftResult + rightResult;
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (target < left || target > right) return;
        else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

}
