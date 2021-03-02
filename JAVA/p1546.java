package baekjoon;
import java.util.Scanner;

public class p1546 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		float score[] = new float[n];
		for(int i = 0;i<score.length;i++) {
			score[i] = stdin.nextInt();
		}
		float max = 0;
		for(int i=0;i<score.length;i++) {
			if(score[i]>max) {
				max = score[i];
			}
		}
		float sum = 0;
		for(int i=0;i<score.length;i++) {
			score[i] = score[i]/max*100;
			sum += score[i];
		}
		float avg = sum/n;
		System.out.println(avg);
	}

}
