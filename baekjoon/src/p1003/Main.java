package p1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] zero = new int[41];
    static int[] one = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        zero[0] = 1;
        zero[1] = 0;

        one[0] = 0;
        one[1] = 1;

        for (int i = 2; i < 41; i++) {
            one[i] = one[i-1] + one[i-2];
            zero[i] = zero[i-1] + zero[i-2];
        }

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(zero[N] + " " + one[N]);
        }
    }
}
