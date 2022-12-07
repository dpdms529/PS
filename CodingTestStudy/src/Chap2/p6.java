package Chap2;

/*
 * 미로 탈출 문제
 * N x M 크기의 미로
 * (1,1)에서 시작, 미로의 출구는 (N,M)
 * 한 번에 한 칸씩 이동 가능
 * 괴물이 있는 부분은 0, 없는 부분은 1
 * 미로를 탈출하기 위해 움직여야 하는 최소 칸의 개수 구하기
 * 칸의 개수는 시작 칸과 마지막 칸을 포함하여 계산
 */

import java.util.*;

public class p6 {

	public static int graph[][];
	public static int n, m;
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {-1,1,0,0};

	public static void bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {y,x});
		while(!queue.isEmpty()) {
			int pos[] = queue.poll();
			y = pos[0];
			x = pos[1];
			for(int i = 0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<m && ny>=0 && ny<n) {
					if(graph[ny][nx] == 1 && (nx!=0 || ny!=0)) {
						queue.offer(new int[] {ny,nx});
						graph[ny][nx] = graph[y][x] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new int[n][m];
		sc.nextLine();
		for(int i = 0;i<n;i++) {
			String s = sc.nextLine();
			for(int j = 0;j<m;j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		bfs(0,0);
		System.out.println(graph[n-1][m-1]);
	}

}
