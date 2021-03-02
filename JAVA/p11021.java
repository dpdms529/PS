package baekjoon;

import java.util.Scanner;

public class p11021 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int t = stdin.nextInt();
		int array[][] = new int[t][2];
		for(int i = 0;i<t;i++) {
			array[i][0] = stdin.nextInt();
			array[i][1] = stdin.nextInt();
		}
		for(int i = 0;i<t;i++) {
			System.out.println("Case #" + (i+1) + ": " + (array[i][0] + array[i][1]));
		}
	}

}
