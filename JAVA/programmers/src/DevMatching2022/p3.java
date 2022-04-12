package DevMatching2022;

import java.util.*;

public class p3 { 
	public static void bfs(ArrayList<ArrayList<Integer>> graph, int k, int a, int b, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		visited[a] = true;
		q.offer(a);
		while(!q.isEmpty()) {
			
		}
	}
	
    public static int solution(int n, int[][] edges, int k, int a, int b) {
        int answer = -1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
            for(int j = 0;j<edges.length;j++){
                if(edges[j][0] == i){
                    graph.get(i).add(edges[j][1]);
                }else if(edges[j][1] == i) {
                	graph.get(i).add(edges[j][0]);
                }
            }
        }
        boolean visited[] = new boolean[n];
        
        return answer;
    }

	public static void main(String[] args) {
		int n = 8;
		int[][] edges = {{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}};
		int k = 4;
		int a = 0;
		int b = 3;
		int result = solution(n, edges, k, a, b);
		System.out.println(result);

	}

}
