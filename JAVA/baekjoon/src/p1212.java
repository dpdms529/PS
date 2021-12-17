import java.util.*;
import java.io.*;

public class p1212 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		for(int i = 0;i<len;i++) {
			int n = Character.getNumericValue(s.charAt(i));
			sb.append((n/2)/2);
			sb.append((n/2)%2);
			sb.append(n%2);
		}
		while(sb.charAt(0) == '0' && sb.length() != 1) {
			sb.deleteCharAt(0);
		}
		System.out.println(sb.toString());
	}

}
