package baekjoon;
import java.util.Scanner;

public class p10707 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int c = stdin.nextInt();
		int d = stdin.nextInt();
		int p = stdin.nextInt();
		int x = a*p;
		int y = b;
		if(p>c) {
			y += d*(p-c);
		}
		if(x<y) {
			System.out.println(x);
		}else {
			System.out.println(y);
		}
	}

}
