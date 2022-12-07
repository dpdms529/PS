import java.util.Scanner;

public class p5063 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int r[] = new int[n];
		int e[] = new int[n];
		int c[] = new int[n];
		for(int i = 0;i<n;i++) {
			r[i] = stdin.nextInt();
			e[i] = stdin.nextInt();
			c[i] = stdin.nextInt();
		}
		for(int i = 0;i<n;i++) {
			if(e[i]-c[i]>r[i]) {
				System.out.println("advertise");
			}else if(e[i]-c[i]==r[i]) {
				System.out.println("does not matter");
			}else {
				System.out.println("do not advertise");
			}
		}
	}

}
