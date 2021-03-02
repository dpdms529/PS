package baekjoon;
import java.util.Scanner;

public class p5575 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int ih[] = new int[3];
		int im[] = new int[3];
		int is[] = new int[3];
		int oh[] = new int[3];
		int om[] = new int[3];
		int os[] = new int[3];
		int mh[] = new int[3];
		int mm[] = new int[3];
		int ms[] = new int[3];
		
		for(int i = 0;i<3;i++) {
			ih[i] = stdin.nextInt();
			im[i] = stdin.nextInt();
			is[i] = stdin.nextInt();
			oh[i] = stdin.nextInt();
			om[i] = stdin.nextInt();
			os[i] = stdin.nextInt();
			if(os[i]-is[i]<0) {
				ms[i] = os[i]-is[i]+60;
				om[i]--;
			}else {
				ms[i] = os[i]-is[i];
			}
			if(om[i]-im[i]<0) {
				mm[i] = om[i]-im[i]+60;
				oh[i]--;
			}else {
				mm[i] = om[i]-im[i];
			}
			mh[i] = oh[i]-ih[i];
		}
		for(int i = 0;i<3;i++) {
			System.out.println(mh[i] + " " + mm[i] + " " + ms[i]);
		}
	}

}
