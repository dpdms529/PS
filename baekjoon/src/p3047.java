import java.util.*;
import java.io.*;

public class p3047 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n[] = new int[3];
		for(int i = 0;i<3;i++) {
			n[i] = stdin.nextInt();
		}
		Arrays.sort(n);
		String s = stdin.next();
		for(int i = 0;i<3;i++) {
			if(s.charAt(i)=='A') System.out.print(String.valueOf(n[0]));
			else if(s.charAt(i)=='B') System.out.print(String.valueOf(n[1]));
			else System.out.print(String.valueOf(n[2]));
			System.out.print(' ');
		}
		

	}

}
