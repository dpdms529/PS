package Chap1;

/*
 * 1이 될 때까지 문제
 * 어떠한 수 N이 1이 될 때까지 다음 두 과정 중 하나를 반복적으로 선택하여 수행
 * 단 두번째 연산은 N이 K로 나누어 떨어질 때만 선택 가능
 * 1. N에서 1을 뺀다
 * 2. N을 K로 나눈다.
 * N과 K가 주어질 때 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수 구하기
 * 1<=N<=100000, 2<=K<=100000
 */

import java.util.*;

public class p2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N, K를 공백을 기준으로 구분하여 입력 받기
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		while(true) {
			//N이 K로 나누어 떨어지는 수가 될 때까지 빼기
			int target = (n/k)*k;
			result += (n-target);
			//N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
			if(n<k) break;
			//K로 나누기
			result += 1;
			n /= k;
		}
		//마지막으로 남은 수에 대하여 1씩 빼기
		result += (n-1);
		System.out.println(result);
	}

}
