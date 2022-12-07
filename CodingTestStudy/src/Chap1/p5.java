package Chap1;

/*
 * 상하좌우 문제
 * N x N 크기의 정사각형 공간
 * 가장 왼쪽 위 좌표는 (1,1), 가장 오른쪽 아래 좌표는 (N,N)
 * 여행가 A는 상,하,좌,우로 이동 가능, 시작좌표는 (1,1)
 * 여행계획서
 * L : 왼쪽으로 한 칸 이동
 * R : 오른쪽으로 한 칸 이동
 * U : 위로 한 칸 이동
 * D : 아래로 한 칸 이동
 * N x N 공간 벗어나는 이동은 무시
 */

import java.util.*;

public class p5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] plans = sc.nextLine().split(" ");
		int x = 1, y = 1;

		int dx[] = {0,0,-1,1};
		int dy[] = {-1,1,0,0};
		char[] moveTypes = {'L', 'R', 'U', 'D'};

		for(int i = 0;i<plans.length;i++) {
			char plan = plans[i].charAt(0);
			int nx = -1, ny = -1;
			for(int j = 0;j<4;j++) {
				if(plan == moveTypes[j]) {
					nx = x + dx[j];
					ny = y + dy[j];
				}
			}
			if(nx<1 || ny<1 || nx>n || ny>n) continue;
			x = nx;
			y = ny;
		}
		System.out.println(x + " " + y);
	}

}
