import java.util.Scanner;

public class p2920 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n[] = new int[8];
		for(int i = 0;i<8;i++) {
			n[i] = stdin.nextInt();
		}
		int b[] = new int[7];
		for(int i = 0;i<7;i++) {
			if(n[i]>n[i+1]) {
				b[i] = 1;
			}else if(n[i]<n[i+1]) {
				b[i] = 2;
			}
		}
		int c1 = 0,c2 = 0;
		for(int i = 0;i<7;i++) {
			if(b[i]==1) {
				c1++;
			}else {
				c2++;
			}
		}
		if(c1==7) {
			System.out.println("descending");
		}else if(c2==7) {
			System.out.println("ascending");
		}else {
			System.out.println("mixed");
		}
	}

}
