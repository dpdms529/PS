import java.util.*;
import java.io.*;

public class p1978 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		ArrayList<Integer> c = new ArrayList<>();
		ArrayList<Integer> prime = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			c.add(Integer.parseInt(st.nextToken()));
		}
		eratos(prime, Collections.max(c));
		for(int i = 0;i<n;i++) {
			if(prime.contains(c.get(i))) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static void eratos(ArrayList<Integer> prime, int m) {
		ArrayList<Boolean> temp = new ArrayList<>(m+1);
		temp.add(false);
		temp.add(false);
		for(int i = 2;i<=m;i++) {
			temp.add(true);
		}
		for(int i = 2;(i*i)<=m;i++) {
			if(temp.get(i)) {
				for(int j = i*i;j<=m;j+=i) temp.set(j, false);
			}
		}
		for(int i = 0;i<=m;i++) {
			if(temp.get(i)) prime.add(i);
		}
	}
	

}
