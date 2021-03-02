package baekjoon;

import java.util.*;
import java.io.*;

public class p12354 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0;i<t;i++) {
			int n = sc.nextInt();
			ArrayList<Integer> h = new ArrayList<>();
			int max = 0;
			int count = 0;
			for(int j = 0;j<n;j++) {
				h.add(sc.nextInt());
				if(h.get(j)>max) max = h.get(j);
				else count++;
			}
			System.out.println("Case #" + String.valueOf(i+1) + ": " +count);
		}
		
	}

}
