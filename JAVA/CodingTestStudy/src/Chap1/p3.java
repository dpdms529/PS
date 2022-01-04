package Chap1;

/*
 * 곱하기 혹은 더하기 문제
 * 각 자리가 숫자(0~9)로만 이루어진 문자열 S가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를
 * 확인하며 숫자 사이에 'x' 혹은 '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수 구하기
 * 단 +보다 x를 먼저 계산하는 일바적인 방식과 달리, 모든 연산은 왼쪽에서부터 순서대로 이루어진다고 가정
 */

import java.util.*;

public class p3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//첫번째 문자를 숫자로 변경한 값을 대입
		long result = str.charAt(0) - '0';
		for(int i = 1;i<str.length();i++) {
			//두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
			int num = str.charAt(i) - '0';
			if(num <= 1 || result <= 1) {
				result += num;
			}else {
				result *= num;
			}
		}
		System.out.println(result);
	}

}
