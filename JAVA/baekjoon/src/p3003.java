import java.util.*;
import java.io.*;

public class p3003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n[] = {1,1,2,2,2,8};
		for(int i = 0;i<n.length;i++) {
			bw.write(n[i]-Integer.parseInt(st.nextToken()) + " ");
		}
		bw.flush();
		bw.close();
		
	}

}
