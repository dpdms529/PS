import java.util.*;
import java.io.*;

public class p18405 {
	public static int n,k;
	public static int graph[][];
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {-1,1,0,0};
	public static Queue<int[]> queue[];
	
	public static void bfs(int y, int x, int s) {
		
		int virus = graph[y][x];
		
		for(int i = 0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(ny>=0 && ny<n && nx>=0 && nx<n) {
				if(graph[ny][nx] == 0) {
					graph[ny][nx] = virus;
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		queue = new Queue[k];
		ArrayList<int[]> virusPos = new ArrayList<>();
		
		for(int i = 0;i<k;i++) {
			queue[i] = new LinkedList<>();
		}
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i = 0;i<s;i++) {
			for(int j = 0;j<k;j++) {
				for(int k = 0;k<n;k++) {
					for(int l = 0;l<n;l++) {
						
					}
					
				}
			}
		}
	}

}
