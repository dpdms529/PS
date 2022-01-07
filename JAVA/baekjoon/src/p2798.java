import java.util.*;
import java.io.*;

public class p2798 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int card[] = new int[n];
		for(int i = 0;i<n;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		int max = 0;
		find : for(int i = 0;i<n-2;i++) {
			if(card[i] >= m) continue;
			for(int j = i+1;j<n-1;j++) {
				if(card[i] + card[j] >= m) continue;
				for(int k = j+1;k<n;k++) {
					result = card[i] + card[j] + card[k];
					if(result <= m && result > max) max = result;
					if(max == m) break find;
				}
			}
		}
		System.out.println(max);

	}

}
