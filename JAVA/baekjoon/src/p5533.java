import java.util.Scanner;

public class p5533 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int s[][] = new int[n][3];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<3;j++) {
				s[i][j] = stdin.nextInt();
			}
		}
		int count = 0;
		int score[] = new int[n];
		for(int g = 0;g<3;g++) {
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					if(i == j) {
						continue;
					}
					if(s[i][g] != s[j][g]) {
						count++;
					}
				}
				if(count == n-1) {
					score[i] += s[i][g];
				}
				count = 0;
			}
		}
		for(int i = 0;i<n;i++) {
			System.out.println(score[i]);
		}
		

	}

}
