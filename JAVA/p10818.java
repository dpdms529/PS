package baekjoon;
import java.util.Scanner;

public class p10818 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int array[] = new int[n];
		for(int i = 0;i<n;i++) {
			array[i] = stdin.nextInt();
		}
		int max = -1000000;
		int min = 1000000;
		for(int i = 0;i<n;i++) {
			if(array[i]>max) {
				max = array[i];
			}
			if(array[i]<min) {
				min = array[i];
			}
		}
		System.out.println(min + " " + max);
	}

}
