import java.util.*;
import java.io.*;

public class p2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int newA=0, newB=0;
		for(int i = 0;i<3;i++) {
			newA += (a%10)*Math.pow(10, 2-i);
			a = a/10;
			newB += (b%10)*Math.pow(10, 2-i);
			b = b/10;
		}
		System.out.println(newA>newB?newA:newB);

	}

}
