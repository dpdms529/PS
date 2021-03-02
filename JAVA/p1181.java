package baekjoon;

import java.util.*;
import java.io.*;

public class p1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			String input = sc.next();
			if(!(list.contains(input))) list.add(input);
		}
		Comparator<String> stringComparator = new Comparator<String>() {
			@Override
			public int compare(String s1,String s2) {
				if(s1.length() == s2.length()) {
					int len = s1.length();
					int i;
					for(i = 0;i<len;i++) {
						if(s1.charAt(i)!=s2.charAt(i)) break;
					}
					return (int)s1.charAt(i) - (int)s2.charAt(i);
				}
				else return s1.length()-s2.length();
			}
		};
		Collections.sort(list,stringComparator);
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
