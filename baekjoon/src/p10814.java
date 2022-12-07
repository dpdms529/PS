import java.util.*;
public class p10814 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		member arr[] = new member[n];
		for(int i = 0;i<n;i++) {
			int age = sc.nextInt();
			String name = sc.next();
			member m = new member(age, name);
			arr[i] = m;
		}
		Arrays.sort(arr);
		for(int i = 0;i<n;i++) {
			System.out.println(arr[i].age + " " + arr[i].name);
		}
		
	}

}

class member implements Comparable<member>{
	int age;
	String name;
	member(int age,String name){
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(member o) {
		int r = Integer.compare(this.age, o.age);
		return r;
	}
}