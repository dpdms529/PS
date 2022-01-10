import java.util.*;
import java.io.*;

public class p10845 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s;
		int last = 0;
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0;i<n;i++) {
			s = br.readLine();
			if(Character.isDigit(s.charAt(s.length()-1))) {
				last = Integer.parseInt(s.split(" ")[1]);
				queue.add(last);
				continue;
			}
			switch(s) {
			case "pop":
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.poll());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				if(queue.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.peek());
				break;
			case "back":
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(last);
				break;
			}
			
		}

	}

}
