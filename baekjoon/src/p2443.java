import java.util.Scanner;

public class p2443 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<i;j++) {
				System.out.print(" ");
			}
			for(int k = 0;k<2*(n-i)-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
