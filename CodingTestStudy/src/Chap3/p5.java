package Chap3;

/*
 * 두 배열의 원소 교체 문제
 * N개의 자연수로 구성된 배열 A, B
 * 최대 K번 바꿔치기 연산 수행 가능
 * 배열 A의 모든 원소 합의 최대값 구하기
 */

import java.util.*;

public class p5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int a[] = new int[n];
		Integer b[] = new Integer[n];
		for(int i = 0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0;i<n;i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());

		int sum = 0;
		for(int i = 0;i<n;i++) {
			if(i<k) sum += b[i];
			else sum += a[i];
		}
		System.out.println(sum);
	}

}
