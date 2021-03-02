package baekjoon;

import java.util.*;
import java.io.*;

public class p1924 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int month[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		final int fDay = 1;
		int sum = fDay;
		for(int i = 1;i<x;i++) {
			sum += month[i-1];
		}
		int day = (sum + y - 1) % 7;
		switch(day) {
		case 0:
			System.out.println("SUN");
			break;
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;
		}
	}
		
}
