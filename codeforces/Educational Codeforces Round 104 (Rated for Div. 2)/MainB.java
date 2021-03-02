
import java.util.*;
import java.io.*;

public class MainB {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n;
		int k;
		int a;
		int b;
		for(int i = 0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = n;
			b = 1;
			for(int j = 1;j<k;j++) {
				if((a-1)==0) a = n;
				else a--;
				if((b+1)==a) {
					if((b+2) == (n+1)) {
						if(a == 1) b = 2;
						else b = 1;
					}
					else b += 2;
				}
				else {
					if((b+1) == (n+1)) {
						if(a == 1) b= 2;
						else b = 1;
					}
					else b++;
				}
			}
			System.out.println(b);
		}
		

	}

}
