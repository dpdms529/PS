package 자료구조.투포인터.p006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수들의 합 5
 * https://www.acmicpc.net/problem/2018
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //몇 개의 연속된 자연수의 합을 가지는지 알고싶은 자연수 N
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while(end != N){
            //연속된 자연수의 합이 N인 경우 카운팅
            if(sum == N){
                count++;
            }

            if(sum > N){
                sum -= start;
                start++;
            }else{
                end++;
                sum += end;
            }
        }

        System.out.println(count);
    }
}
