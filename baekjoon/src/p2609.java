import java.util.*;
import java.io.*;

public class p2609 {
	
	public static int gcd(int a, int b) {
		if(a%b==0) return b;
		else return gcd(b,a%b);
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = gcd(a,b);
		System.out.println(gcd);
		System.out.println(a*b/gcd);

	}

}
