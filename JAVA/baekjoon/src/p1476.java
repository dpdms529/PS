import java.util.*;
import java.io.*;

public class p1476 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int earth = 1, sun = 1, moon = 1;
		int year = 1;
		while(earth!=e || sun!=s || moon!=m) {
			earth++;
			sun++;
			moon++;
			if(earth==16) earth = 1;
			if(sun==29) sun = 1;
			if(moon==20) moon = 1;
			year++;
		}
		System.out.println(year);
	}

}
