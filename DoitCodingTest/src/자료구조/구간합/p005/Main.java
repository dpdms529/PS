package 자료구조.구간합.p005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나머지 합
 * https://www.acmicpc.net/problem/10986
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //수의 개수
        int N = Integer.parseInt(st.nextToken());

        //나누어 떨어져야 하는 수
        int M = Integer.parseInt(st.nextToken());

        //1~i까지의 구간 합을 M으로 나눈 나머지 배열
        int[] remainders = new int[N+1];

        //나머지가 같은 수의 개수
        long[] numbersOfSameRemainder  = new long[M];

        //M으로 나누어 떨어지는 구간의 개수
        long numberOfIntervalsDisivibleByM = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 1;i<=N;i++){
            int number = Integer.parseInt(st.nextToken());

            //1~i까지의 구간 합을 M으로 나눈 나머지 구하기
            remainders[i] = (remainders[i-1] + number) % M;

            //구간의 길이가 1이고 M으로 나누어 떨어지는 경우
            if(remainders[i] == 0) numberOfIntervalsDisivibleByM++;

            //같은 나머지를 갖는 인덱스의 수 카운팅
            numbersOfSameRemainder[remainders[i]]++;
        }

        for(int i = 0;i<M;i++){
            //나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 구하기 : nC2
            numberOfIntervalsDisivibleByM += numbersOfSameRemainder[i] * (numbersOfSameRemainder[i] - 1) / 2;
        }

        System.out.println(numberOfIntervalsDisivibleByM);
    }
}
