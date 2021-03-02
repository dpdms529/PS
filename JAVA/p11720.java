package baekjoon;
import java.util.Scanner;

public class p11720 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		String s = stdin.next();
		int t = 0;
		for(int i = n-1;i>=0;i--) {
			t+=Integer.parseInt(s.substring(i,i+1));
		}
		System.out.println(t);
	}

}
