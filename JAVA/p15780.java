package baekjoon;

import java.util.*;
import java.io.*;

public class p15780 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int k = stdin.nextInt();
		int sum = 0;
		for(int i = 0;i<k;i++) {
			int m = stdin.nextInt();
			if(m%2==0) sum+=m/2;
			else sum+=(m/2)+1;
		}
		if(n<=sum) System.out.println("YES");
		else System.out.println("NO");
	}

}
