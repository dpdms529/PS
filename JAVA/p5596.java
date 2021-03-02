package baekjoon;
import java.util.Scanner;

public class p5596 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int min[] = new int[4];
		int man[] = new int[4];
		int s=0,t=0;
		for(int i = 0;i<4;i++) {
			min[i] = stdin.nextInt();
			s += min[i];
		}
		for(int i = 0;i<4;i++) {
			man[i] = stdin.nextInt();t += man[i];
		}
		if(s>=t) {
			System.out.println(s);
		}else {
			System.out.println(t);
		}
	}

}
