import java.util.Scanner;

public class p5565 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int total = stdin.nextInt();
		int b[] = new int[9];
		for(int i = 0;i<9;i++) {
			b[i] = stdin.nextInt();
			total-=b[i];
		}
		System.out.println(total);
		
	}

}
