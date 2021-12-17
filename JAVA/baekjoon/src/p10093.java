import java.util.Scanner;

public class p10093 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		long a = stdin.nextLong();
		long b = stdin.nextLong();
		if(a>b) {
			long t = b;
			b = a;
			a = t;
		}
		long t = b-a-1;
		if(a==b) {
			System.out.println(0);
		}else {
			System.out.println(t);
			for(long i = 1;i<=t;i++) {
				System.out.print(a+i + " ");
			}
		}
		
		
	}
}
