package baekjoon;
import java.util.Scanner;

public class p5597 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n[] = new int[28];
		int s[] = new int[30];
		for(int i = 0;i<30;i++) {
			s[i] = i+1;
		}
		for(int i = 0;i<28;i++) {
			n[i] = stdin.nextInt();
			for(int j = 0;j<30;j++) {
				if(n[i]==s[j]) {
					s[j] = 0;
				}
			}
		}
		int a=-1,b=-1;
		for(int i = 0;i<30;i++) {
			if(s[i]!=0 && a==-1) {
				a = i+1;
			}else if(s[i]!=0) {
				b = i+1;
			}
		}
		System.out.println(a);
		System.out.println(b);
	}

}
