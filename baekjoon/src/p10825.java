import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
	public String name;
	public int ko;
	public int eg;
	public int ma;
	@Override
	public int compareTo(Student o) {
		if(this.ko == o.ko) {
			if(this.eg == o.eg) {
				if(this.ma == o.ma) {
					return this.name.compareTo(o.name);
				}else return o.ma - this.ma;
			}else return this.eg - o.eg;
		}else return o.ko - this.ko;
	}
	
}

public class p10825 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Student s[] = new Student[n];
		for(int i = 0;i<n;i++) {
			s[i] = new Student();
			s[i].name = sc.next();
			s[i].ko = sc.nextInt();
			s[i].eg = sc.nextInt();
			s[i].ma = sc.nextInt();
		}
		Arrays.sort(s);
	
		for(int i = 0;i<n;i++) {
			System.out.println(s[i].name);
		}
	}

}