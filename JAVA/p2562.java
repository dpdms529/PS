package baekjoon;
import java.util.Scanner;

public class p2562 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n[] = new int[9];
		for(int i = 0;i<9;i++) {
			n[i] = stdin.nextInt();
		}
		int max = 0;
		int num = 0;
		for(int i = 0;i<9;i++) {
			if(n[i]>max) {
				max = n[i];
				num = i;
			}
		}
		System.out.println(max);
		System.out.println(num+1);
		
	}

}
