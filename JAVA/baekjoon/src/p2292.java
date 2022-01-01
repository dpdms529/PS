import java.util.*;
import java.io.*;

public class p2292 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 1;i<=n;i+=6*count) {
			count++;
			if(n<=i) break;
		}
		count++;
		System.out.println(count);
	}

}