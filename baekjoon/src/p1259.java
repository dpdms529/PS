import java.util.*;
import java.io.*;

public class p1259 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(!(s = br.readLine()).equals("0")) {
			int idx = s.length()/2 - 1;
			if(idx == -1) {
				System.out.println("yes");
				continue;
			}
			for(int i = idx;i>-1;i--) {
				if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
					System.out.println("no");
					break;
				}
				if(i == 0) System.out.println("yes");
			}
		}
	}

}
