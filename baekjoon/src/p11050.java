import java.util.*;
import java.io.*;

public class p11050 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int fn = factorial(n);
		int fk = factorial(k);
		int fnmk = factorial(n-k);
		System.out.println(fn/(fk*fnmk));
		
	}
	
	public static int factorial(int n) {
		if(n < 2) {
			return 1;
		}else {
			return n * factorial(n-1);
		}
	}

}
