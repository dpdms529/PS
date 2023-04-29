package 자료구조.배열과리스트.p002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평균
 * https://www.acmicpc.net/problem/1546
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //시험 본 과목 개수
        int N = Integer.parseInt(br.readLine());

        //성적 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        //점수 최대값
        int M = 0;

        //점수 합
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());

            //점수 최대값 구하기
            M = Math.max(M, score);

            //점수 합 구하기
            sum += score;
        }

        //새로운 성적 평균 구하기
        double average = sum * 100.0 / M / N;

        //새로운 성적 평균 출력
        System.out.println(average);
    }
}
