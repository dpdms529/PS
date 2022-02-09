import java.util.*;
import java.io.*;

public class p1436 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		String title = "666";
		while(cnt != n) {
			if(title.contains("666")) {
				cnt++;
				if(cnt == n) break;
			}
			title = String.valueOf(Integer.parseInt(title) + 1);
		}
		System.out.println(title);
	}

}
