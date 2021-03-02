package baekjoon;
import java.util.Scanner;

public class p5554 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int c = stdin.nextInt();
		int d = stdin.nextInt();
		int t = a+b+c+d;
		int x = t/60;
		int y = t%60;
		System.out.println(x);
		System.out.println(y);
	}

}
