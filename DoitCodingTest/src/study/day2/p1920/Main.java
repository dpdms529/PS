package study.day2.p1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int find = Integer.parseInt(st.nextToken());

            binarySearch(numbers, find);
        }

    }

    static void binarySearch(int[] numbers, int find) {
        int start = 0;
        int end = numbers.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(numbers[mid] == find) {
                System.out.println(1);
                return;
            }else if(numbers[mid] > find) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        System.out.println(0);
    }
}
