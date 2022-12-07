import java.util.*;
import java.io.*;

public class p10828 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0;i<n;i++) {
			s = br.readLine();
			if(Character.isDigit(s.charAt(s.length()-1))) {
				stack.push(Integer.parseInt(s.split(" ")[1]));
				continue;
			}
			switch(s) {
			case "pop":
				if(stack.empty()) System.out.println(-1);
				else System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.empty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if(stack.empty()) System.out.println(-1);
				else System.out.println(stack.lastElement());
			}
			
		}
	}

}
