package 자료구조.투포인터.p008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좋다
 * https://www.acmicpc.net/problem/1253
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //수의 개수
        int N = Integer.parseInt(br.readLine());

        //수 배열
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int count = 0;

        for(int i = 0;i<N;i++){
            int start = 0;
            int end = N - 1;

            while(start < end){
                long sum = A[start] + A[end];

                if(sum == A[i]){
                    if(start != i && end != i){
                        count++;
                        break;
                    }else if(start == i){
                        start++;
                    }else if(end == i){
                        end--;
                    }
                }

                if(sum < A[i]){
                    start++;
                }

                if(sum > A[i]){
                    end--;
                }
            }
        }

        System.out.println(count);
    }
}
