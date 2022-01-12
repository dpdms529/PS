package Chap2;

import java.util.*;

public class p4 {
	
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		//현재 노드를 방문 처리
		visited[start] = true;
		//큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			//큐에서 하나의 원소를 뽑아 출력
			int x = q.poll();
			System.out.print(x + " ");
			//해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
			for(int i = 0;i<graph.get(x).size();i++) {
				int y = graph.get(x).get(i);
				if(!visited[y]) {
					q.offer(y);
					visited[y] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		//그래프 초기화
				for(int i = 0;i<9;i++) {
					graph.add(new ArrayList<Integer>());
				}
				
				//노드 1에 연결된 노드 정보 저장
				graph.get(1).addAll(List.of(2,3,8));
				
				//노드 2에 연결된 노드 정보 저장
				graph.get(2).addAll(List.of(1,7));
				
				//노드 3에 연결된 노드 정보 저장
				graph.get(3).addAll(List.of(1,4,5));
				
				//노드 4에 연결된 노드 정보 저장
				graph.get(4).addAll(List.of(3,5));

				//노드 5에 연결된 노드 정보 저장
				graph.get(5).addAll(List.of(3,4));
				
				//노드 6에 연결된 노드 정보 저장
				graph.get(6).addAll(List.of(7));
				
				//노드 7에 연결된 노드 정보 저장
				graph.get(7).addAll(List.of(2,6,8));
				
				//노드 8에 연결된 노드 정보 저장
				graph.get(8).addAll(List.of(1,7));
				
				bfs(1);
	}

}
