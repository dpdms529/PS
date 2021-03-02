package baekjoon;

import java.util.*;
import java.io.*;

public class p15803 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		double x3 = sc.nextDouble();
		double y3 = sc.nextDouble();
		if((y2-y1)/(x2-x1) == (y3-y1)/(x3-x1) || (y2-y1)/(x2-x1) == (y3-y2)/(x3-x2) || (y3-y1)/(x3-x1) == (y3-y2)/(x3-x2)) {
			System.out.println("WHERE IS MY CHICKEN?");
		}else System.out.println("WINNER WINNER CHICKEN DINNER!");
		
	}

}
