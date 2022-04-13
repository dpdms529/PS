package Chap1;

/*
 * 모험가 길드 문제
 * N명의 모험가를 대상으로 공포도 측정
 * 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있음
 * N명의 모험가에 대한 정보가 주어졌을 때 여행을 떠날 수 있는 그룹 수의 최대값 구하기
 */

import java.util.*;

public class p4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s[] = new int[n];
		for(int i = 0;i<n;i++) {
			s[i] = sc.nextInt();
		}
		Arrays.sort(s);
		int group = 0;
		int cnt = 0;
		for(int i = 0;i<n;i++) {
			cnt++;
			if(s[i] <= cnt) {
				group++;
				cnt = 0;
			}
		}
		System.out.println(group);
	}

}
