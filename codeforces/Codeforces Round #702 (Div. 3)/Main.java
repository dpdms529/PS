import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n;
		int isBig;
		int d;
		ArrayList<Integer> a = new ArrayList<>();
		int count[] = new int[t];
		for(int i = 0;i<t;i++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				a.add(Integer.parseInt(st.nextToken()));
				if(j>0) {
					isBig = a.get(j) - a.get(j-1);
					if(isBig>0) {
						d = a.get(j);
						if((float)d/a.get(j-1)>2) {
							while(d > a.get(j-1)) {
								if(d%2 != 0) d++;
								d /= 2;
								count[i]++;
							}
							count[i]--;
						}

					}else if(isBig<0) {
						d = a.get(j-1);
						if((float)d/a.get(j)>2) {
							while(d > a.get(j)) {
								if(d%2 != 0) d++;
								d /= 2;
								count[i]++;
							}
							count[i]--;
						}
					}
				}
				
			}
			bw.write(count[i] + "\n");
			a.clear();
			
		}
		bw.flush();

	}

}