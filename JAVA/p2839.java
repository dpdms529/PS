package baekjoon;

import java.util.*;
import java.io.*;
import java.math.*;

public class p2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r;
		int m = n / 5;
		int arr[] = new int[m+1];
		int t;
		for(int i = 0;i<m+1;i++) {
			t = n - i * 5;
			if(t%3 == 0) {
				int s = t/3;
				arr[i] = i + s; 
			}else {
				arr[i] = -1;
			}
		}
		Arrays.sort(arr);
		for(int i = 0;i<m+1;i++) {
			if(arr[i]>0) {
				System.out.println(arr[i]);
				return;
			}
		}
		System.out.println(-1);
		
	}

}
