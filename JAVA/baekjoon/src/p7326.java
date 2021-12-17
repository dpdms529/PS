import java.util.*;
import java.io.*;

public class p7326 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int x,y;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(y>x || y==x-1 || y<x-2) System.out.println("No Number");
			else if(x%2 == 0) System.out.println(x + y);
			else System.out.println(x + y - 1);
		}

	}

}
