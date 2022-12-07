import java.util.*;
import java.io.*;

public class p2231 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		char arr[];
		String i = "1";
		int result=0;
		while(!i.equals(n)) {
			result = Integer.parseInt(i);
			arr = i.toCharArray();
			for(int j = 0;j<arr.length;j++) {
				result += Character.getNumericValue(arr[j]);
			}
			if(String.valueOf(result).equals(n)) break;
			i = String.valueOf(Integer.parseInt(i) + 1);
		}
		if(String.valueOf(result).equals(n)) System.out.println(i);
		else System.out.println(0);
		
	}

}
