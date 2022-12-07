import java.util.*;
import java.io.*;

public class p2490 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0;i<3;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = 0;
			for(int j = 0;j<4;j++) {
				String s = st.nextToken();
				if(s.equals("0")) count++;
			}
			if(count==4) System.out.println("D");
			else if(count==3) System.out.println("C");
			else if(count==2) System.out.println("B");
			else if(count==1) System.out.println("A");
			else System.out.println("E");
		}
	}

}
