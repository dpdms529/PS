import java.util.Scanner;

public class p10569 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int t = stdin.nextInt();
		int s[] = new int[t];
		for(int i = 0;i<t;i++) {
			int v = stdin.nextInt();
			int e = stdin.nextInt();
			s[i] = 2-v+e;
		}
		for(int i = 0;i<t;i++) {
			System.out.println(s[i]);
		}
	}

}
