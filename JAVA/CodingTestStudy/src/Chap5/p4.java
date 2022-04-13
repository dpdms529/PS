package Chap5;

/*
 * 1로 만들기 문제
 * 정수 X가 주어졌을 때 사용할 수 있는 연산
 * 1. X가 5로 나누어 떨어지면 5로 나눔
 * 2. X가 3으로 나누어 떨어지면 3으로 나눔
 * 3. X가 2로 나누어 떨어지면 2로 나눔
 * 4. X에서 1을 뺌
 * 연산 4개를 사용하여 1로 만들고자 함
 * 연산을 사용하는 횟수의 최솟값 구하기
 */

import java.util.*;

public class p4 {

	public static int[] d = new int[30001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		for(int i = 2;i<=x;i++) {
			d[i] = d[i-1] + 1;
			if(i%2 == 0) {
				d[i] = Math.min(d[i], d[i/2] + 1);
			}
			if(i%3 == 0) {
				d[i] = Math.min(d[i], d[i/3] + 1);
			}
			if(i%5 == 0) {
				d[i] = Math.min(d[i],  d[i/5] + 1);
			}
		}
		System.out.println(d[x]);
	}

}
