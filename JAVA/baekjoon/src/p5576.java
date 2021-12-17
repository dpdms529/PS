import java.util.Scanner;

public class p5576 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int w[] = new int[10];
		int k[] = new int[10];
		for(int i = 0;i<10;i++) {
			w[i] = stdin.nextInt();
		}
		for(int i = 0;i<10;i++) {
			k[i] = stdin.nextInt();
		}
		int m;
		for(int i = 0;i<9;i++) {
			m = i;
			for(int j = i+1;j<10;j++) {
				if(w[j]<w[m]) {
					m = j;
				}
			}
			int t = w[i];
			w[i] = w[m];
			w[m] = t;
		}
		for(int i = 0;i<9;i++) {
			m = i;
			for(int j = i+1;j<10;j++) {
				if(k[j]<k[m]) {
					m = j;
				}
			}
			int t = k[i];
			k[i] = k[m];
			k[m] = t;
		}
		
		int ws = w[7]+w[8]+w[9];
		int ks = k[7]+k[8]+k[9];
		System.out.println(ws + " " + ks);
		
	}

}
