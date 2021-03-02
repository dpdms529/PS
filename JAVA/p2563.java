package baekjoon;

import java.util.*;
import java.io.*;

public class p2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		boolean map[][] = new boolean[101][101];
		int left;
		int bottom;
		int count = 0;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken());
			bottom = Integer.parseInt(st.nextToken());
			for(int j = 0;j<10;j++) {
				for(int k = 0;k<10;k++) {
					if(!map[bottom+j][left+k]) {
						map[bottom+j][left+k] = true;
						count++;
					}
				}
			}
		}
		System.out.println(count);

	}

}
