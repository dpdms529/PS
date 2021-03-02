package baekjoon;
import java.util.Scanner;

public class p15820 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int s1 = stdin.nextInt();
		int s2 = stdin.nextInt();
		int result = 0;
		for(int i = 0;i<s1;i++) {
			int a1 = stdin.nextInt();
			int a2 = stdin.nextInt();
			if(a1 != a2) {
				result = 1;
			}
		}
		if(result == 0) {
			for(int i = 0;i<s2;i++) {
				int a1 = stdin.nextInt();
				int a2 = stdin.nextInt();
				if(a1 != a2) {
					result = 2;
				}
			}
		}
		switch(result) {
		case 0:
			System.out.println("Accepted");
			break;
		case 1:
			System.out.println("Wrong Answer");
			break;
		case 2:
			 System.out.println("Why Wrong!!!");
			 break;
		}
	}

}
