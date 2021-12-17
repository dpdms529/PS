import java.util.*;
import java.io.*;

public class p2675 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int r[]	= new int[t];
		String s[] = new String[t];
		StringTokenizer st;
		for(int i = 0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			s[i] = st.nextToken();
			for(int j = 0;j<s[i].length();j++) {
				for(int k = 0;k<r[i];k++) {
					System.out.print(s[i].charAt(j));
				}
			}
			System.out.println();
		}

		
		
		
	}

}
