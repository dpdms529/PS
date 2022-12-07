import java.util.*;
import java.io.*;
import java.math.*;

public class p15829{

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String s = br.readLine();
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0;i<l;i++) {
			BigInteger n = BigInteger.valueOf(s.charAt(i) - 'a' + 1);
			BigInteger p = BigInteger.valueOf(31).pow(i);
			sum = sum.add(n.multiply(p)).mod(BigInteger.valueOf(1234567891));	
		}
		System.out.println(sum);
		
	}

}
