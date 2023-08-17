package study.day4.p1456;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int max = (int)1e7;

        boolean[] primeNumbers = new boolean[max+1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (primeNumbers[i]) {
                for (int j = i + i; j <= max; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        Set<Long> set = new HashSet<>();
        for (int i = 2; i <= max; i++) {
            if (primeNumbers[i]) {

                for (long j = (long)i*i; j <= B; j*=i) {
                    if (A <= j && j <= B) {
                        set.add(j);
                    }

                    if(j > B/i) break;
                }
            }
        }

        System.out.println(set.size());

    }
}
