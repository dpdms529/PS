import java.util.*;
import java.io.*;

public class p15725 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int result = 0;
		if(s.contains("x")) {
			int i = s.indexOf("x");
			if(i==0) result = 1;
			else if(s.charAt(0)=='-' && s.charAt(1)=='x') result = -1;
			else if(s.charAt(0)=='-' && s.charAt(1)!='x') result = Integer.parseInt(s.substring(0, i));
			else result = Integer.parseInt(s.substring(0,i));
		}
		System.out.println(result);
	}

}
