import java.util.*;
import java.io.*;

public class p1018 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String arr[] = new String[n];
		for(int i = 0;i<n;i++) {
			arr[i] = br.readLine();
		}
		int min = 64;
		for(int i = 0;i<n-7;i++) {
			for(int j = 0;j<m-7;j++) {
				int r = check(arr, i, j);
				if(r<min) {
					min = r;	
				}
			}
		}
		System.out.println(min);
		
	}
	
	public static int check(String[] arr, int row, int col) {
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = row;i<row+8;i++) {
			for(int j = col;j<col+8;j++) {
				if((i-row + j)%2 == 0) {
					if(arr[i].charAt(j) == 'W') cnt1++;
					if(arr[i].charAt(j) == 'B') cnt2++;
				}else {
					if(arr[i].charAt(j) == 'B') cnt1++;
					if(arr[i].charAt(j) == 'W') cnt2++;
				}
			}
		}
		if(cnt1-cnt2>0) return cnt2;
		else return cnt1;
	}
}
