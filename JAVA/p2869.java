package baekjoon;

import java.util.*;
import java.io.*;

public class p2869 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int r = (v-a)/(a-b)+1;
		if((v-a)%(a-b)!=0) r++; 
		System.out.println(r);
		
	}

}
