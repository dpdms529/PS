import java.util.*;
import java.io.*;

public class p2108 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int sum = 0;
		int check[] = new int[8001];
		for(int i = 0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			check[arr[i] + 4000]++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round((double)sum/n)).append('\n');
		Arrays.sort(arr);
		sb.append(arr[n/2]).append('\n');
		int max = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0;i<8001;i++) {
			if(check[i]>max) max = check[i];
		}
		for(int i = 0;i<8001;i++) {
			if(check[i] == max) list.add(i-4000);
		}
		if(list.size()>1) sb.append(list.get(1)).append('\n');
		else sb.append(list.get(0)).append('\n');
		sb.append(arr[n-1]-arr[0]).append('\n');
		System.out.println(sb.toString());
	}

}
