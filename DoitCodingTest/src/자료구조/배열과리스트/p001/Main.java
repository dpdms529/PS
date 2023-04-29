package 자료구조.배열과리스트.p001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 숫자의 합
 * https://www.acmicpc.net/problem/11720
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //숫자 개수
        int N = Integer.parseInt(br.readLine());

        //합 구하기
        int sumOfNumbers = Arrays.stream(br.readLine()  //숫자 N개 입력 받기
                        .split(""))    //숫자 분리하기
                        .mapToInt(number -> Integer.parseInt(number))   //int형으로 변환
                        .sum();

        //합 출력
        System.out.println(sumOfNumbers);
    }
}
