package baekjoon;
import java.io.*;
import java.util.*;

public class p1075 {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());
		int result = n%100;
		if((n % f) != 0) {
			if(result < (n % f)) {
				result += (f - (n % f));
			}else {
				result = (result - (n % f)) % f;
			}
		}else {
			result %= f;
		}
		System.out.println(String.format("%02d", result));
	}

}
