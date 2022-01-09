import java.util.*;
import java.io.*;

public class p15686 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n][n];
		ArrayList<int[]> house = new ArrayList<>();
		ArrayList<int[]> chicken = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					house.add(new int[]{i,j});
				}else if(arr[i][j] == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		int dis[][] = new int[house.size()][chicken.size()];
		for(int i = 0;i<house.size();i++) {
			for(int j = 0;j<chicken.size();j++) {
				dis[i][j] = Math.abs(house.get(i)[0] - chicken.get(j)[0]) + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
				System.out.println(dis[i][j]);
			}
			System.out.println();
		}
		
		

	}

}
