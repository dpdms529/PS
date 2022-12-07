import java.util.*;
import java.io.*;

public class p1316 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean alp[];
		int n = Integer.parseInt(br.readLine());
		String s;
		int count = 0;
		for(int i = 0;i<n;i++) {
			alp = new boolean[26];
			s = br.readLine();
			boolean ismatch = true;
			for(int j = 0;j<s.length()-1;j++) {
				if(alp[s.charAt(j)-97]) {
					ismatch = false;
					break;
				}
				if(s.charAt(j)!=s.charAt(j+1)) {
					alp[s.charAt(j)-97] = true;
				}
			}
			if(alp[s.charAt(s.length()-1)-97]) {
				ismatch = false;
			}
			if(ismatch) count++;
		}
		System.out.println(count);
	}

}
