import java.util.Scanner;

public class p5618 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int s[] = new int[3];
		for(int i = 0;i<n;i++) {
			s[i] = stdin.nextInt();
		}
		
		for(int i = 1;i<=s[0];i++) {
			if(s[0]%i == 0 && s[1]%i == 0 && s[2]%i == 0) {
				System.out.println(i);
			}
		}
		
	}
}
