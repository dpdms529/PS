import java.util.*;
import java.io.*;

public class p1654 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[k];
		for(int i = 0;i<k;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long start = 1;
		long end =  2147483647;
		long result = 0;
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for(int i = 0;i<k;i++) {
				long div = arr[i] / mid;
				sum += div;
			}
			if(sum < n) end = mid - 1;
			else {
				result = mid;
				start = mid + 1;
			}
		}
		System.out.println(result);
	}

}
