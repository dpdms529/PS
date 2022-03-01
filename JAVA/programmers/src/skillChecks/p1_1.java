package skillChecks;

import java.util.*;

public class p1_1 {
	public static long solution(long n) {
        ArrayList<Long> arr = new ArrayList<>();
        while(n!=0){
            long tmp = n%10;
            arr.add(tmp);
            n = n/10;
        }
        Collections.sort(arr);

        long answer = 0;
        for(int i = 0;i<arr.size();i++){
            answer += arr.get(i) * (long)Math.pow(10,i);
        }

        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution(118372));
	}

}
