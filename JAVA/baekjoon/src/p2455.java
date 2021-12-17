import java.util.Scanner;

public class p2455 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n[][] = new int[4][2];
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<2;j++) {
				n[i][j] = stdin.nextInt();
			}
		}
		int p[] = new int[4];
		p[0] = n[0][1];
		for(int i = 1;i<4;i++) {
			p[i] = p[i-1] - n[i][0] + n[i][1];
		}
		int max = 0;
		for(int i = 0;i<4;i++) {
			if(p[i]>max) {
				max = p[i];
			}
		}
		System.out.println(max);
	}

}
