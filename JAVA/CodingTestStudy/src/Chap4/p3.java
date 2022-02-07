package Chap4;

/*
 * 떡복이 떡 만들기 문제
 * 높이 H를 지정하면 줄지어진 떡을 한 번에 절단
 * 높이가 H보다 긴 떡은 H 위 부분이 잘림
 * 요청한 떡의 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최대값 구하기
 */

import java.util.*;

public class p3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int start = 0;
		int end = (int)1e9;
		int result = 0;
		while(start <= end) {
			long total = 0;
			int mid = (start + end) / 2;
			for(int i = 0;i<n;i++) {
				if(arr[i] > mid) total += arr[i] - mid;
			}
			if(total < m) end = mid - 1;
			else {
				result = mid;
				start = mid + 1;
			}
		}
		System.out.println(result);
		
	}

}
