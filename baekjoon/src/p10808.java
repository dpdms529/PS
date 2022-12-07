import java.util.*;
import java.io.*;

public class p10808 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int arr[] = new int[26];
		String s = stdin.next();
		for(int i = 0;i<s.length();i++) {
			int a = s.charAt(i)-97;
			arr[a]++;
		}
		System.out.print(arr[0]);
		for(int i = 1;i<26;i++) {
			System.out.print(" " + arr[i]);
		}
	}

}
