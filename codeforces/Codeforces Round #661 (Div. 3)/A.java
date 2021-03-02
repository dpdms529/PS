package codeforce;
import java.util.Scanner;
import java.util.ArrayList;

public class A {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int t = stdin.nextInt();
		for(int i = 0;i<t;i++) {
			int n = stdin.nextInt();
			ArrayList<Integer> a = new ArrayList<>();
			for(int j = 0;j<n;j++) {
				a.add(stdin.nextInt());
			}
			a.sort(null);
			for(int j = 0;j<a.size()-1;j++) {
				for(int k = j+1;k<a.size();k++) {
					if(a.get(j)-a.get(k)>=-1 && a.get(j)-a.get(k)<=1) {
						if(a.get(j)<=a.get(k)) {
							a.remove(j);
							j--;
							break;
						}else{
							a.remove(k);
							k--;
						}
					}
				}
			}
			if(a.size()==1) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		
		
	}

}
