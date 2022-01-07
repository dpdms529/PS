package Chap1;

/*
 * 시각 문제
 * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는
 * 모든 경우의 수 구하기
 */

import java.util.*;

public class p6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for(int i = 0;i<=n;i++) {
			for(int j = 0;j<60;j++) {
				for(int k = 0;k<60;k++) {
					if(i%10 == 3 || j/10 == 3 || j%10 == 3 || k/10 == 3 || k%10 == 3) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
