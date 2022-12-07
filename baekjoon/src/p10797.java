import java.util.Scanner;

public class p10797 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int d = stdin.nextInt();
		int c[] = new int[5];
		for(int i = 0;i<5;i++) {
			c[i] = stdin.nextInt();
		}
		int count = 0;
		for(int i = 0;i<5;i++) {
			if(c[i] == d) {
				count++;
			}
		}
		System.out.println(count);
		
	}

}
