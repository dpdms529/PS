package baekjoon;
import java.util.Scanner;

public class p2440 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
