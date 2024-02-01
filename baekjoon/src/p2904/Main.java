package p2904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> primes = new ArrayList<>();
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        findPrime();

        int[] count = new int[primes.size()];
        int[][] count2 = new int[N][primes.size()];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < primes.size(); j++) {
                int prime = primes.get(j);

                if (prime > num) break;

                while (num % prime == 0) {
                    num /= prime;
                    count[j]++;
                    count2[i][j]++;
                }
            }
        }

        int maxScore = 1;
        int moveCount = 0;

        for (int i = 0; i < primes.size(); i++) {
            int c = count[i] / N;
            if(c == 0) continue;

            maxScore *= Math.pow(primes.get(i), c);

            for (int j = 0; j < N; j++) {
                if(count2[j][i] < c) {
                    moveCount += c - count2[j][i];
                }
            }
        }

        System.out.println(maxScore + " " + moveCount);
    }

    static void findPrime() {
        boolean[] isPrime = new boolean[MAX + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i <= MAX; i++) {
            if(isPrime[i]){
                primes.add(i);
            }
        }
    }
}
