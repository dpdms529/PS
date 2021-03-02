package baekjoon;
import java.util.Scanner;

public class p8958 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		String s[] = new String[n];
		int count=0,sum=0;
		int score[] = new int[n];
		for(int i = 0;i<n;i++) {
			s[i] = stdin.next();
			for(int j = 0;j<s[i].length();j++) {
				if(s[i].charAt(j)=='O') {
					count++;
				}else {
					count = 0;
				}
				sum+=count;
			}
			score[i] = sum;
			count = 0;
			sum = 0;
		}
		for(int i = 0;i<n;i++) {
			System.out.println(score[i]);
		}
		
	}

}
