package baekjoon;
import java.io.*;
import java.util.*;

public class p2506 {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0;i<n;i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		int score = 0;
		int result = 0;
		for(int i = 0;i<n;i++) {
			if(arr.get(i)==1) {
				score += 1;
				result += score;
			}else {
				score = 0;
			}
		}
		System.out.println(result);
	}

}
