import java.util.*;
import java.io.*;

public class p2023 {
	public static int n = 0;
	
	public static boolean isPrime(int n) {
		if(n<2) return false;
		for(int i = 2;i<=Math.sqrt(n);i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void findInteresting(int num, int d) {
		if(d==n)System.out.println(num);
		else {
			for(int i = 1;i<10;i+=2) {
				int tmp = num * 10 + i;
				if(isPrime(tmp)) {
					findInteresting(tmp,d+1);
				}
			}
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int prime[] = {2, 3, 5, 7};
		for(int i = 0;i<4;i++) {
			findInteresting(prime[i],1);
		}
	}

}
