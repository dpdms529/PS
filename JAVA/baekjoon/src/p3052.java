import java.util.Scanner;

public class p3052 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int arr[] = new int[10];
		int n[] = new int[42];
		int count = 0;

		for(int i = 0;i<10;i++) {
			arr[i] = stdin.nextInt();
			n[arr[i]%42] ++;
		}
		
		for(int i = 0;i<42;i++) {
			if(n[i]!=0) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
