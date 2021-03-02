package baekjoon;

import java.util.*;
import java.io.*;

public class p10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int idx[] = new int[26];
		Arrays.fill(idx, -1);
		for(int i = 0;i<s.length();i++){
			if(idx[(int)s.charAt(i)-97] == -1) {
				idx[(int)s.charAt(i)-97] = i;
			}
		}
		for(int i = 0;i<26;i++) {
			if(i<25) System.out.print(idx[i] + " ");
			else System.out.println(idx[i]);
		}
	}

}
