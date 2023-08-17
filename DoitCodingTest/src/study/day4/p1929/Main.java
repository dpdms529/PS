package study.day4.p1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] primeNumbers = new boolean[N+1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for (int i = 2; i*i <= N; i++) {
            if(primeNumbers[i]) {
                for (int j = i+i; j <= N; j+=i) {
                    primeNumbers[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if(primeNumbers[i]) {
                System.out.println(i);
            }
        }

    }
}
