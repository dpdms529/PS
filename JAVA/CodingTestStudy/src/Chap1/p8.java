package Chap1;

/*
 * 문자열 재정렬 문제
 * 알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력
 * 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에 모든 숫자를 더한 값 이어서 출력
 */

import java.util.*;

public class p8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		ArrayList<Character> list = new ArrayList<>();
		int sum = 0;
		for(int i = 0;i<s.length();i++) {
			if(Character.isLetter(s.charAt(i))) list.add(s.charAt(i));
			else sum += (s.charAt(i) - '0');
		}
		Collections.sort(list);
		for(int i = 0;i<list.size();i++) {
			System.out.print(list.get(i));
		}
		if(sum != 0) System.out.println(sum);

	}

}
