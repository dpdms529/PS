import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
	public int left;
	public int right;
	
	public Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return this.left + " " + this.right;
	}

	@Override
	public int compareTo(Pair o) {
		if(this.right==o.right) return this.left - o.left;
		else return this.right - o.right;
	}
	
	
}

public class p11651 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			list.add(new Pair(sc.nextInt(),sc.nextInt()));
		}
		list.sort(null);
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

	}

}
