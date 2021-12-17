import java.util.*;
import java.io.*;

public class p4673 {
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 1 ; i<10001; i++) {
			if(!list.contains(i)) {
				d(i);
			}else {
				continue;
			}
		}
		
		for(int i = 1;i<10001;i++) {
			if(!list.contains(i)) {
				bw.append(i + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static void d(int n) {
		if(n>10000) {
			return;
		}else {
			int result = n;
			while(n>0) {
				result += n%10;
				n /= 10;
			}
			if(result<=10000 && !list.contains(result)) {
				list.add(result);
				d(result);
			}
		}
	}

}
