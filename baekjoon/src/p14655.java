import java.util.*;
import java.io.*;

public class p14655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i = 0;i<n;i++) {
			sum += Math.abs(sc.nextInt());
		}
		for(int i = 0;i<n;i++) {
			sum += Math.abs(sc.nextInt());
		}
		System.out.println(sum);
		
	}

}
