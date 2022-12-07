import java.util.Scanner;

public class p11943 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int c = stdin.nextInt();
		int d = stdin.nextInt();
		int n;
		if(a+d<b+c) {
			n = a+d;
		}else {
			n = b+c;
		}
		System.out.println(n);
	}

}
