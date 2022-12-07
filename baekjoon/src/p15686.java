import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p15686 {
	public static int n, m;
	public static int[][] graph;
	public static int[][] alive;
	public static ArrayList<int[]> chicken = new ArrayList<>();
	public static ArrayList<int[]> house = new ArrayList<>();
	public static int min = (int)1e9;

	public static int distance(){
		int result = 0;
		for(int i = 0;i<house.size();i++){
			int dist = (int)1e9;
			for(int j = 0;j<m;j++){
				dist = Math.min(dist, Math.abs(house.get(i)[0]-alive[j][0]) + Math.abs(house.get(i)[1]-alive[j][1]));
			}
			result += dist;
		}
		return result;
	}

	public static void dfs(int depth, int index){
		if(depth == m){
			min = Math.min(min, distance());
			return;
		}else{
			for(int i = index;i<chicken.size();i++){
				alive[depth] = chicken.get(i);
				dfs(depth+1, i+1);
			}
		}

	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		alive = new int[m][2];
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j]==1) house.add(new int[]{i,j});
				if(graph[i][j]==2) chicken.add(new int[]{i,j});
			}
		}
		dfs(0, 0);
		System.out.println(min);

	}
}
