import java.util.*;
import java.io.*;

public class p10866 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque();
		for(int i = 0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int m = 0;
			if(st.hasMoreTokens()) {
				m = Integer.parseInt(st.nextToken());
			}
			switch(s) {
			case "push_front":
				deque.offerFirst(m);
				break;
			case "push_back":
				deque.offerLast(m);
				break;
			case "pop_front":
				if(deque.isEmpty()) System.out.println(-1);
				else System.out.println(deque.pollFirst());
				break;
			case "pop_back":
				if(deque.isEmpty()) System.out.println(-1);
				else System.out.println(deque.pollLast());
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if(deque.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(deque.isEmpty()) System.out.println(-1);
				else System.out.println(deque.peekFirst());
				break;
			case "back":
				if(deque.isEmpty()) System.out.println(-1);
				else System.out.println(deque.peekLast());
				break;
			}
			
		}
	}

}
