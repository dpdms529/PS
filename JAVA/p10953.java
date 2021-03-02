package baekjoon;
import java.util.Scanner;

public class p10953 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		String s[] = new String[n];
		int sum[] = new int[n];
		for(int i = 0;i<n;i++) {
			s[i] = stdin.next();
			sum[i] = Character.getNumericValue(s[i].charAt(0)) +  Character.getNumericValue(s[i].charAt(2));
		}
		for(int i = 0;i<n;i++) {
			System.out.println(sum[i]);
		}
		
	}

}
