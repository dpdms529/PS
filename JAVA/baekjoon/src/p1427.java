import java.util.*;
import java.io.*;

public class p1427 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0;i<n.length();i++) {
			list.add(Character.getNumericValue(n.charAt(i)));
		}
		Collections.sort(list);
		Collections.reverse(list);
		for(int i = 0;i<list.size();i++) {
			System.out.print(list.get(i));
		}
	}

}
