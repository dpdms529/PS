package baekjoon;
import java.util.*;
import java.io.*;

public class p1188 {
	static int result = 0;

	static void cut(int n, int m) {
		int t,r;
		if(n==0 || m<=1) {
			return;
		}else {
			if(n>m) {
				n = n % m;
				r = 0;
				t = m;
			}else {
				if(m%n==0) {
					r = m / n - 1;
					t = 0;
				}else {
					t = m % n;
					r = m / n;
				}
			}
			result += r * n;
			cut(n,t);
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		cut(n,m);
		System.out.println(result);
	}
}
