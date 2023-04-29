package 자료구조.구간합.p003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //수의 개수
        int N = Integer.parseInt(st.nextToken());

        //합을 구해야 하는 횟수
        int M = Integer.parseInt(st.nextToken());

        //수 배열
        int[] numbers = new int[N+1];

        //합 배열
        int[] sums = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1;i<=N;i++){
            numbers[i] = Integer.parseInt(st.nextToken());

            //i번째 숫자까지의 합 구하기
            sums[i] = sums[i-1] + numbers[i];
        }

        //구간 합 구하기
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(sums[end] - sums[start-1]);
        }
    }
}
