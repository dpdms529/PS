import java.util.Scanner;

public class p17248 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int t = stdin.nextInt();
		int x[] = new int[t];
		int y[] = new int[t];
		int z[] = new int[t];
		int s[] = new int[t];
		for(int i = 0;i<t;i++) {
			x[i] = stdin.nextInt();
			y[i] = stdin.nextInt();
			z[i] = stdin.nextInt();
			s[i] = 0;
		}
		for(int i = 0;i<t;i++) {
			while(x[i]<y[i]) {
				x[i] += z[i]*(s[i]+1);
				s[i]++;
			}
		}
		for(int i = 0;i<t;i++) {
			System.out.println(s[i]);
		}
		
	}

}
