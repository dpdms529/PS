import java.util.Scanner;

public class p11721 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String s = stdin.next();
		int l = s.length();
		for(int i = 0;i<l;i+=10) {
			if(i+10>l) {
				System.out.println(s.substring(i));
			}else {
				System.out.println(s.substring(i,i+10));
			}
		}
	}

}
