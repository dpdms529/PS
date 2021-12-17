import java.util.*;
import java.io.*;

public class p1152 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr = s.split(" ");
		int result = arr.length; 
		if(arr.length!=0) {
			if(arr[0].equals("")) result--;
		}
		System.out.println(result);
	}

}
