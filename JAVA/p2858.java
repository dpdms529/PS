package baekjoon;
import java.util.Scanner;

public class p2858 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int r,b;
		r = stdin.nextInt();
		b = stdin.nextInt();
		int a = r + b;
		int l=0,w=0;
		for(int i = 3;i<a;i++) {
			if(a%i == 0) {
				l = i;
				w = a/i;
				if(b == (l-2) * (w-2)){
					break;
				}
			}
		}
		if(l<w) {
			int t = l;
			l = w;
			w = t;
		}
		System.out.println(l + " " + w);
	}

}
