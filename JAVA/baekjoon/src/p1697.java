import java.util.*;
import java.io.*;

public class p1697 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int visited[] = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		int x = n;
		q.offer(x);
		while(!q.isEmpty()) {
			x = q.poll();
			if(x == k) break;
			int move[] = {-1,1,x};
			for(int i = 0;i<3;i++) {
				int nx = x + move[i];
				if(nx>=0 && nx<=100000) {
					if(visited[nx] == 0) {
						q.offer(nx);
						visited[nx] = visited[x] + 1;
					}
				}
			}
		}
		
		System.out.println(visited[k]);

	}

}
