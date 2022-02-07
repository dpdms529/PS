package Chap5;

/*
 * 개미 전사 문제
 * 식량창고 N개에 대한 정보가 주어졌을 때 얻을 수 있는 식량의 최대값 구하기
 * 최소한 한 칸 이상 떨어진 식량창고를 약탈해야 함
 */

import java.util.*;

public class p3 {
	
	public static int[] d = new int[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		d[0] = arr[0];
		d[1] = arr[1];
		for(int i = 2;i<n;i++) {
			d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
		}
		System.out.println(d[n-1]);
		

	}

}
