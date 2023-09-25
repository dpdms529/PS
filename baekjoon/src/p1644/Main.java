package p1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i*i <= N ; i++) {
            for (int j = i+i; j <= N ; j += i) {
                isPrime[j] = false;
            }
        }

        ArrayList<Integer> prime = new ArrayList<>();
        prime.add(0);
        for (int i = 0; i < N+1; i++) {
            if(isPrime[i]) prime.add(i);
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while(left <= right) {

            if(sum > N) {
                sum -= prime.get(left);
                left++;
            }else {
                if(sum == N) {
                    cnt++;
                }

                right++;

                if(right < prime.size()) {
                    sum += prime.get(right);
                }else break;
            }
        }

        System.out.println(cnt);
    }
}
