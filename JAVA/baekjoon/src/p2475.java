import java.util.*;
import java.io.*;

public class p2475 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n[] = new int[5];
		for(int i = 0;i<5;i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for(int i = 0;i<5;i++) {
			sum += n[i]*n[i];
		}
		int result = sum%10;
		System.out.println(result);
		
	}

}
