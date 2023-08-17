package p2243.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static int s = 1;
    static final int MAX_TASTE = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (s < MAX_TASTE) {
            s *= 2;
        }

        tree = new long[2 * s];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {   //사탕 빼기
                //꺼낼 사탕의 순위
                int b = Integer.parseInt(st.nextToken());
                int left = 0;
                int right = s;
                int target = 0;

                while (left <= right) {
                    int mid = (left + right) / 2;
                    long rank = query(1, s, 1, 1, mid);
                    if (rank < b) {
                        left = mid + 1;
                    } else {
                        target = mid;
                        right = mid - 1;
                    }
                }

                System.out.println(target);
                update(1,s,1,target,-1);

            } else if (a == 2) {    //사탕 넣기
                //넣을 사탕의 맛
                int b = Integer.parseInt(st.nextToken());
                //넣을 사탕의 개수
                long c = Integer.parseInt(st.nextToken());
                update(1, s, 1, b, c);
            }
        }
    }

    static long query(int left, int right, int node, int start, int end) {
        if (start > right || end < left) return 0;
        else if (start <= left && right <= end) return tree[node];
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
