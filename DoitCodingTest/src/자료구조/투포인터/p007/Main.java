package 자료구조.투포인터.p007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 주몽
 * https://www.acmicpc.net/problem/1940
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //재료의 개수
        int N = Integer.parseInt(br.readLine());

        //갑옷을 만드는데 필요한 수
        int M = Integer.parseInt(br.readLine());

        //각 재료가 가지는 고유한 번호
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //재료 번호 정렬
        Arrays.sort(numbers);

        int start = 0;
        int end = N-1;
        int count = 0;

        //만들 수 있는 갑옷 개수 구하기
        while(start < end){
            int sum = numbers[start] + numbers[end];

            if(sum == M){
                count++;
                start++;
                end--;
            }

            if(sum > M){
                end--;
            }

            if(sum < M){
                start++;
            }
        }

        System.out.println(count);
    }
}