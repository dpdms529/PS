import java.util.*;
import java.io.*;

public class p1085 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int r = w-x;
		int t = h-y;
		int min = x;
		if(y<min) {
			min = y;
			if(r<min) {
				min = r;
				if(t<min) {
					min = t;
				}
			}else if(t<min) {
				min = t;
			}
		}else if(r<min) {
			min = r;
			if(t<min) {
				min = t;
			}
		}else if(t<min) {
			min = t;
		}
		bw.write(String.valueOf(min));
		bw.flush();
		
	}

}
