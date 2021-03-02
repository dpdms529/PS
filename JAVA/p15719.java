package baekjoon;
import java.util.*;
import java.io.*;
import java.math.*;

public class p15719 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int s = 0;
		int t = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			s += Integer.parseInt(st.nextToken());
//			if(i==n-1) {
//				s += 15293;
//				break;
//			}
//			s += i+1;
		}
		for(int i = 1;i<n;i++) {
			t += i;
		}
		int r = s-t;
		System.out.println(r);
		
	}

}
