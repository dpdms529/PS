import java.util.*;
import java.io.*;

public class p2606 {
	
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static boolean visited[];
	public static int cnt = 0;
	
	public static void dfs(int x) {
		visited[x] = true;
		cnt++;
		for(int i = 0;i<graph.get(x).size();i++) {
			int y = graph.get(x).get(i);
			if(!visited[y]) dfs(y);
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		for(int i = 0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[n+1];
		
		for(int i = 0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		dfs(1);
		System.out.println(cnt-1);

	}

}
