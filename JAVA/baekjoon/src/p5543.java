import java.util.Scanner;

public class p5543 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int b[] = new int[3];
		int s[] = new int[2];
		int mb = 2000;
		int ms = 2000;
		for(int i = 0;i<3;i++) {
			b[i] = stdin.nextInt();
			if(b[i]<mb) {
				mb = b[i];
			}
		}
		for(int i = 0;i<2;i++) {
			s[i] = stdin.nextInt();
			if(s[i]<ms) {
				ms = s[i];
			}
		}
		System.out.println(mb + ms - 50);
	}

}
