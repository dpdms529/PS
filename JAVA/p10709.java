package baekjoon;

import java.io.*;
import java.util.*;

public class p10709 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		String[] c = new String[h];
		int min;
		int k;
		for(int i = 0;i<h;i++) {
			c[i] = br.readLine();
			for(int j = 0;j<w;j++) {
				if(c[i].charAt(j) == 'c') {
					if(j == w-1) bw.write(Integer.toString(0));
					else bw.write(Integer.toString(0) + ' ');
				}
				else {
					min = 0;
					for(k = j-1;k>=0;k--) {
						min++;
						if(c[i].charAt(k) == 'c') {
							if(j == w-1) bw.write(Integer.toString(min));
							else bw.write(Integer.toString(min) + ' ');
							break;
						}
					}
					if(k == -1) {
						if(j == w-1) bw.write(Integer.toString(k));
						else bw.write(Integer.toString(k) + ' ');
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
		
	}

}
