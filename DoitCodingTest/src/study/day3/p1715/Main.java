package study.day3.p1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        long result = 0;

        if (N == 1) {
            result = 0;
        } else {
            while(pq.size() > 1) {
                int sum = pq.poll() + pq.poll();
                pq.offer(sum);
                result += sum;
            }
        }

        System.out.println(result);

    }
}
