import java.util.Scanner;

public class p10039 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int s[] = new int[5];
		for(int i = 0;i<5;i++) {
			s[i] = stdin.nextInt();
			if(s[i]<40) {
				s[i] = 40;
			}
		}
		int total = 0;
		for(int i = 0;i<5;i++) {
			total += s[i];
		}
		int avg = total/5;
		System.out.println(avg);
	}

}
