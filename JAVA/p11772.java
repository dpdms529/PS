package baekjoon;

import java.util.*;
import java.io.*;

public class p11772 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s[] = new String[n];
		for(int i = 0;i<n;i++) {
			s[i] = sc.next();
		}
		int x = 0;
		for(int i=0;i<n;i++) {
			x += Math.pow(Double.parseDouble(s[i].substring(0,s[i].length()-1)), Double.parseDouble(s[i].substring(s[i].length()-1)));	
		}
		System.out.println(x);
	}

}
