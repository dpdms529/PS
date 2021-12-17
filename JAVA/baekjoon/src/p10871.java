import java.util.Scanner;

public class p10871 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int x = stdin.nextInt();
		int array[] = new int[n];
		for(int i = 0;i<n;i++) {
			array[i] = stdin.nextInt();
		}
		for(int i : array) {
			if(i<x) {
				System.out.print(i + " ");
			}
		}
	}

}

