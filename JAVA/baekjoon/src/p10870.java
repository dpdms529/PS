import java.util.*;
import java.io.*;

public class p10870 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.write(String.valueOf(fibonacci(n)));
		bw.flush();
	}
	public static int fibonacci(int n) {
		if(n<=1) {
			return n;
		}else {
			return (fibonacci(n-1) + fibonacci(n-2));
		}
	}

}
