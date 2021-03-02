package baekjoon;

import java.util.*;
import java.io.*;

public class p11367 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		for(int i = 0;i<n;i++) {
			String name = stdin.next();
			int score = stdin.nextInt();
			String grade = null;
			if(score>=97 && score<=100) grade = "A+";
			else if(score>=90 && score<=96) grade = "A";
			else if(score>=87 && score<=89) grade = "B+";
			else if(score>=80 && score<=86) grade = "B";
			else if(score>=77 && score<=79) grade = "C+";
			else if(score>=70 && score<=76) grade = "C";
			else if(score>=67 && score<=69) grade = "D+";
			else if(score>=60 && score<=66) grade = "D";
			else if(score>=0 && score<=59) grade = "F";
			System.out.println(name + " " + grade);
		}
	}

}
