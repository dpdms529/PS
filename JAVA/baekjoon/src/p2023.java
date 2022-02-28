import java.util.*;
import java.io.*;

public class p2023 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int start = (int)Math.pow(10, n-1);
		int end = (int)Math.pow(10, n);
		
		boolean arr[] = new boolean[end];
		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;
		for(int i = 2;i<=Math.sqrt(end-1);i++) {
			if(arr[i]) {
				for(int j = i+i;j<end;j+=i) {
					arr[j] = false;
				}
				
			}

		}
		
		while(start < end) {
			int d = 1;
			boolean isInteresting = true;
			for(int i = 0;i<n;i++) {
				if(!arr[start/d]) {
					isInteresting = false;
					break;
				}
				d *= 10;
			}
			if(isInteresting) System.out.println(start);
			start++;
		}
	}

}
