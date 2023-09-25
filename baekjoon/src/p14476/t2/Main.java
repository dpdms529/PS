package p14476.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] A = new int[N];
        int[] B = new int[N];
        A[0] = nums[0];
        B[N - 1] = nums[N - 1];

        for (int i = 1; i < N; i++) {
            A[i] = gcd(A[i - 1], nums[i]);
        }

        for (int i = N - 2; i >= 0; i--) {
            B[i] = gcd(B[i + 1], nums[i]);
        }

        int max = -1;
        int idx = -1;

        for (int i = 0; i < N; i++) {
            int gcd;

            if (i == 0) gcd = B[1];
            else if (i == N - 1) gcd = A[N - 2];
            else gcd = gcd(A[i - 1], B[i + 1]);

            if (nums[i] % gcd != 0 && gcd > max) {
                max = gcd;
                idx = i;
            }
        }

        System.out.println(max == -1 ? max : max + " " + nums[idx]);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }


}
