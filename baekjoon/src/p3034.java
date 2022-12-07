import java.util.*;
import java.io.*;
import java.math.*;

public class p3034 {
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		double w = stdin.nextDouble();
		double h = stdin.nextDouble();
		double x = Math.sqrt((w*w)+(h*h));
		String result;
		for(int i = 0;i<n;i++) {
			int l = stdin.nextInt();
			if(l<=w) result = "DA";
			else if(l<=h) result = "DA";
			else if(l<=x) result = "DA";
			else result = "NE";
			System.out.println(result);
		}
		
	}

}
