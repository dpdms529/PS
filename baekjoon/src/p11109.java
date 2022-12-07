import java.util.*;
import java.io.*;

public class p11109 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0;i<t;i++) {
			int d = sc.nextInt();
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			if(n*s<d+n*p) System.out.println("do not parallelize");
			else if(n*s>d+n*p) System.out.println("parallelize");
			else System.out.println("does not matter");
		}
		
	}

}
