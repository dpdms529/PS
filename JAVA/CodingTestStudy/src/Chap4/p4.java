package Chap4;

/*
 * 정렬된 배열에서 특정 수의 개수 구하기 문제
 * 오름차순으로 정렬된 N개의 원소를 포함하는 수열에서 x가 등장하는 횟수 계산하기
 */

import java.util.*;

public class p4 {

	public static int lowerBound(int[] arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr[mid] >= target) end = mid;
			else start = mid + 1;
		}
		return end;
	}

	public static int upperBound(int[] arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end) / 2;
			if(arr[mid] > target) end = mid;
			else start = mid + 1;
		}
		return end;
	}

	public static int countByRange(int[] arr, int leftValue, int rightValue) {
		int rightIndex = upperBound(arr, rightValue, 0, arr.length);
		int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
		return rightIndex - leftIndex;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}

		int cnt = countByRange(arr, x, x);

		if(cnt == 0) System.out.println(-1);
		else System.out.println(cnt);

	}

}
