package baekjoon;
import java.util.Scanner;

public class p5347 {
	static int gcm(int a,int b) {
		if(a%b==0) {
			return b;
		}else {
			return gcm(b,a%b);
		}
	}

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		int r[] = new int[n];
		for(int i = 0;i<n;i++) {
			a[i] = stdin.nextInt();
			b[i] = stdin.nextInt();
			int gcm,aa,bb;
			if(a[i]>=b[i]) {
				gcm = gcm(a[i],b[i]);
			}else {
				gcm = gcm(b[i],a[i]);
			}
			aa = a[i]/gcm;
			bb = b[i]/gcm;
			r[i] = aa*bb*gcm;
		}
		for(int i = 0;i<n;i++) {
			System.out.println(r[i]);
		}
		
		
	}

}
