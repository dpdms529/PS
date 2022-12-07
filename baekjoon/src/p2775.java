import java.util.*;
import java.io.*;

public class p2775 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int k,n;
		for(int i = 0;i<t;i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			System.out.println(calc(k,n));
		}

	}
	
	public static int calc(int k, int n) {
		if(k == 0 || n == 1) {
			return n;
		}else {
			return calc(k-1,n) + calc(k,n-1);
		}
	}

}
