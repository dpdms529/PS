import java.util.ArrayList;
import java.util.Scanner;

public class p4153 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a=-1,b=-1,c=-1;
		int i = 0;
		ArrayList<String> s = new ArrayList<String>();
		while(a!=0&&b!=0&&c!=0 && a<30000 && b<30000 && c<30000) {
			a = stdin.nextInt();
			b = stdin.nextInt();
			c = stdin.nextInt();
			int t;
			if(a>b) {
				t = b;
				b = a;
				a = t;
				if(b>c) {
					t = c;
					c = b;
					b = t;
					if(a>b) {
						t = b;
						b = a;
						a = t;
					}
				}
			}else if(b>c) {
				t = c;
				c = b;
				b = t;
				if(a>b) {
					t = b;
					b = a;
					a = t;
				}
			}
			
			
			if(a!=0 && b!=0 && c!=0) {
				if(a*a + b*b == c*c) {
					s.add("right");
				}else {
					s.add("wrong");
				}
				i++;
			}
		}
		for(int j = 0;j<i;j++) {
			System.out.println(s.get(j));
		}
		
	}

}
