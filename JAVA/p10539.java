package baekjoon;

import java.util.*;
import java.io.*;

public class p10539 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for(int i = 0;i<n;i++) {
			b[i] = sc.nextInt();
			a[i] = b[i] * (i+1);
		}
		for(int i = n-1;i>0;i--) {
			a[i] -= a[i-1];
		}
		
		for(int i=0;i<n;i++) {
			if(i<n-1) System.out.print(a[i] + " ");
			else System.out.println(a[i]);
		}
	}

}
