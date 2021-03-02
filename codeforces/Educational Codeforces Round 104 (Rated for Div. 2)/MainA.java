
import java.util.*;
import java.io.*;

public class MainA {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n[] = new int[t];
		ArrayList<Integer> a = new ArrayList<>();
		int min;
		int count;
		for(int i = 0;i<t;i++) {
			n[i] = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			min = 0;
			count = 0;
			for(int j = 0;j<n[i];j++) {
				a.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(a);
			min = Collections.min(a);
			for(int j = 0;j<n[i];j++) {
				if(a.get(j) == min)count++;
			}
			bw.write((n[i]-count) + "\n" );
			a.clear();
		}
		bw.flush();
	}

}
