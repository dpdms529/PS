import java.util.Scanner;

public class p10952 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		while(a!=0 || b!=0) {
			System.out.println(a+b);
			a = stdin.nextInt();
			b = stdin.nextInt();
		}
		
		
	}

}
