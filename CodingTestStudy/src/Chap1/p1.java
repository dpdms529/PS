package Chap1;

/*
 * 거스름 돈 문제
 * 거스름돈 종류 : 500원, 100원, 50원, 10원
 * 거스름돈은 무한히 존재
 * 손님에게 거슬러 주어야 할 돈이 N원일 때 거슬러 주어야 할 동전의 최소 개수 구하기
 * 거슬러 줘야 할 돈 N은 항상 10의 배수
 */

public class p1 {

	public static void main(String[] args) {
		int n = 1260;
		int cnt = 0;
		int[] coinTypes = {500, 100, 50, 10};
		
		for(int i = 0;i<4;i++) {
			cnt += n /coinTypes[i];
			n %= coinTypes[i];
		}
		System.out.println(cnt);
	}

}
