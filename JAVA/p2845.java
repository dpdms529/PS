package baekjoon;

import java.util.*;
import java.io.*;

public class p2845 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int t = l*p;
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<5;i++) {
			int n = Integer.parseInt(st.nextToken());
			if(i==4) {
				System.out.println(n-t);
			}else {
				System.out.print((n-t)+" ");
			}
		}

	}

}
