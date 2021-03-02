package baekjoon;
import java.util.Scanner;

public class p17247 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int m = stdin.nextInt();
		int p[][] = new int[n][m];
		int x1=0,x2=0,y1=0,y2=0;
		boolean p1 = false,p2 = false;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				p[i][j] = stdin.nextInt();
				if(p[i][j] == 1 && p1 == false) {
					x1 = j;
					y1 = i;
					p1 = true;
				}
				if(p[i][j] == 1 && p1 == true) {
					x2 = j;
					y2 = i;
					p2 = true;
				}
			}
		}
		int x,y;
		if(x1>x2) {
			x = x1-x2;
		}else {
			x = x2-x1;
		}
		if(y1>y2) {
			y = y1-y2;
		}else {
			y = y2-y1;
		}
		int d = x+y;
		System.out.println(d);
	}

}
