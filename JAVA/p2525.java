package baekjoon;
import java.util.Scanner;

public class p2525 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int c = stdin.nextInt();
		a += c/60;
		b += c%60;
		if(b>=60) {
			a += b/60;
			b = b%60;
		}
		if(a>=24) {
			a = a-24;
		}
		System.out.println(a + " " + b);
	}

}
