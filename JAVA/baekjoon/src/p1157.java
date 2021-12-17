import java.util.*;
import java.io.*;

public class p1157 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toLowerCase();
		int arr[] = new int[26];
		for(int i = 0;i<s.length();i++) {
			arr[s.charAt(i)-97]++;
		}
		int max = -1;
		char result = ' ';
		for(int i = 0;i<26;i++) {
			if(arr[i]>max) {
				max = arr[i];
				result = (char)(65 + i);
			}else if(arr[i]==max) {
				result = '?';
			}
		}
		System.out.println(result);

	}

}
