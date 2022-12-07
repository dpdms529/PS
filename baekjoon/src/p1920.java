import java.util.*;
import java.io.*;

public class p1920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> na = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			na.add(Integer.parseInt(st.nextToken()));  
		}
		na.sort(null);
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> ma = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<m;i++) {
			ma.add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0;i<m;i++) {
			System.out.println(binarySearch(na,ma.get(i)));;
		}
		
		
	}
	
	public static int binarySearch(ArrayList<Integer> na, int ma) {
		int left = 0;
		int right = na.size() - 1;
		int mid = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(ma == na.get(mid)) {
				return 1;
			}else {
				if(ma < na.get(mid)) {
					right = mid -1;
				}else {
					left = mid + 1;
				}
			}
		}
		return 0;
	}

}
