package p1806.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = nums[0];
        int min = N+1;

        while(true) {
            if(sum >= S) {
                int length = end - start + 1;
                min = Math.min(min, length);
                sum -= nums[start];
                start++;
            }else {
                end++;
                if(end == N) break;
                sum += nums[end];
            }
        }

        if(min == N+1) System.out.println(0);
        else System.out.println(min);
    }
}
