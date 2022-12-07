import java.util.*;
import java.io.*;

public class p11131 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			if(sum<0) {
				System.out.println("Left");
			}else if(sum>0) {
				System.out.println("Right");
			}else {
				System.out.println("Equilibrium");
			}
		}
		
	}

}
