import java.util.*;

public class p10250 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int t;
		t = stdin.nextInt();
		int h[] = new int[t];
		int w[] = new int[t];
		int n[] = new int[t];
		
		for(int i = 0;i<t;i++) {
			h[i] = stdin.nextInt();
			w[i] = stdin.nextInt();
			n[i] = stdin.nextInt();
		}
		int y[] = new int[t];
		int x[] = new int[t];
		for(int i = 0;i<t;i++) {
			if(n[i]%h[i] == 0) {
				x[i] = n[i]/h[i];
				y[i] = h[i];
			}else {
				x[i] = n[i]/h[i] + 1;
				y[i] = n[i]%h[i];
			}
		}
//		int count = 0;
//		a:for(int i = 0;i<t;i++) {
//			for(int j = 1;j<=w[i];j++) {
//				x[i] = j;
//				for(int k = 1;k<=h[i];k++) {
//					y[i] = k;
//					count++;
//					if(count == n[i]) {
//						count = 0;
//						continue a;
//					}
//				}
//			}
//		}
		for(int i = 0;i<t;i++) {
			System.out.println(y[i]*100 + x[i]);
		}
		
		
	}

}
