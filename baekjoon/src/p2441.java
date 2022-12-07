import java.util.Scanner;

public class p2441 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<i;j++) {
				System.out.print(" ");
			}
			for(int k = 0;k<n-i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
