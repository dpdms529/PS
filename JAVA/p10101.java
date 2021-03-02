package baekjoon;
import java.util.Scanner;

public class p10101 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int c = stdin.nextInt();
		if(a==60&&b==60&&c==60) {
			System.out.println("Equilateral");
		}else if(a+b+c==180) {
			if(a!=b && a!=c && b!=c) {
				System.out.println("Scalene");
			}else if(a!=b || a!=c || b!=c) {
				System.out.println("Isosceles");
			}
		}else {
			System.out.println("Error");
		}
	}

}
