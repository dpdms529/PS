package codeforce;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class B {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int t = stdin.nextInt();
		for(int i = 0;i<t;i++) {
			int n = stdin.nextInt();
			ArrayList<Integer> c = new ArrayList<>();
			ArrayList<Integer> o = new ArrayList<>();
			for(int j = 0;j<n;j++) {
				c.add(stdin.nextInt());
			}
			for(int j = 0;j<n;j++) {
				o.add(stdin.nextInt());
			}
			int minC = Collections.min(c);
			int minO = Collections.min(o);
			long sum = 0;
			for(int j = 0;j<n;j++) {
				int mc = c.get(j)-minC;
				int mo = o.get(j)-minO;
				if(mc>=mo) sum += mc;
				else if(mo>mc) sum += mo;
			}
			System.out.println(sum);
			
		}

	}

}
