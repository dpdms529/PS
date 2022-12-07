package Chap1;

/*
 * 왕실의 나이트 문제
 * 8 x 8 좌표
 * 나이트는 L자 형태로만 이동 가능, 정원 밖으로는 나갈 수 없음
 * 1. 수평으로 두 칸 이동한 뒤 수직으로 한 칸 이동
 * 2. 수직으로 두 칸 이동한 뒤 수평으로 한 칸 이동
 * 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수 출력하기
 */

import java.util.*;

public class p7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int x = s.charAt(0) - 'a' + 1;
		int y = s.charAt(1) - '0';

		int dx[] = {2,2,1,-1,-2,-2,1,-1};
		int dy[] = {-1,1,-2,-2,-1,1,2,2};

		int cnt = 0;
		for(int i = 0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<1 || nx>8 || ny<1 || ny>8) continue;
			cnt++;
		}
		System.out.println(cnt);

	}

}
