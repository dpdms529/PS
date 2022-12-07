import java.util.*;
import java.io.*;

class PairInt implements Comparable<PairInt>{
	private int key;
	private int value;
	PairInt(int key, int value){
		this.key = key;
		this.value = value;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "PairInt [key=" + key + ", value=" + value + "]";
	}

	@Override
	public int compareTo(PairInt o) {
		return this.getValue() - o.getValue();
	}
	
}

public class p1966 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Queue<PairInt> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++) {
				q.offer(new PairInt(j,Integer.parseInt(st.nextToken())));
			}
			int cnt = 0;
			while(!q.isEmpty()) {
				int max = Collections.max(q).getValue();
				while(q.peek().getValue()!=max) {
					q.offer(q.poll());
				}
				cnt++;
				PairInt target = q.poll();
				if(target.getKey() == m) break;
			}
			System.out.println(cnt);
		}
	}

}
