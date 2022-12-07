import java.util.*;
import java.io.*;

public class p2822 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,Integer> score = new HashMap<>();
		for(int i = 0;i<8;i++) {
			score.put(Integer.parseInt(br.readLine()), i+1);
		}
		ArrayList<Integer> list = new ArrayList<Integer>(score.keySet());
		Collections.sort(list);
		int sum = 0;
		ArrayList<Integer> p = new ArrayList<Integer>();
		for(int i = 0;i<5;i++) {
			sum += list.get(7-i);
			p.add(score.get(list.get(7-i)));
		}
		p.sort(null);
		System.out.println(sum);
		for(int i = 0;i<5;i++) {
			if(i < 4) System.out.print(p.get(i) + " ");
			else System.out.println(p.get(i));
		}
	}

}
