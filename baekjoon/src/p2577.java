import java.util.Scanner;

public class p2577 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int c = stdin.nextInt();
		int result = a*b*c;
		int arr[] = new int [10];
		int d = 1000000000;
		while(result/d==0) {
			d/=10;
		}
		while(d!=0) {
			int t = result/d;
			result = result%d;
			d/=10;
			arr[t]++;
		}
		for(int i = 0;i<10;i++) {
			System.out.println(arr[i]);
		}
	}

}
