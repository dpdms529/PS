import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class p1010 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			BigInteger arr[] = new BigInteger[m+1];
			arr[0] = BigInteger.ONE;
			for(int j = 1;j<=m;j++) {
				arr[j] = arr[j-1].multiply(BigInteger.valueOf(j));
			}
			BigInteger result = arr[m].divide(arr[n].multiply(arr[m-n]));
			System.out.println(result);
		}

	}

}
