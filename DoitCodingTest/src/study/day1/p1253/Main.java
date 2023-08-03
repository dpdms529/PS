package study.day1.p1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while (left < right) {
                long sum = numbers[left] + numbers[right];

                if (sum < numbers[i]) {
                    left++;
                }else if (sum > numbers[i]) {
                    right--;
                }else {
                    if(left != i && right != i) {
                        count++;
                        break;
                    }else if (left == i) {
                        left++;
                    }else if (right == i) {
                        right--;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
