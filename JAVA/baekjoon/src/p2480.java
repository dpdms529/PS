import java.util.Scanner;

public class p2480 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int c = stdin.nextInt();
		int p = 0;
		if(a==b && a==c && b==c	) {
			p = 10000 + a*1000;
		}else if(a!=b && a!=c && b!=c) { 
			int max = 1;
			if(a>max) max = a;
			if(b>max) max = b;
			if(c>max) max = c;
			p = max * 100;
		}else {
			if(a==b) {
				p = 1000 + a*100;
			}else if(a==c) {
				p = 1000 + a*100;
			}else if(b==c){
				p = 1000 + b*100;
			}
		}
		System.out.println(p);
	}

}
