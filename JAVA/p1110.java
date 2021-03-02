package baekjoon;

import java.util.Scanner;

public class p1110 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int a = n/10;
		int b = n%10;
		int sum = a+b;
		int tmp = b*10 + sum%10;
		int count = 1;
		while(tmp != n) {
			a = tmp/10;
			b = tmp%10;
			sum = a + b;
			tmp = b*10 + sum%10;
			count++;
		}
		System.out.println(count);
	}

}
