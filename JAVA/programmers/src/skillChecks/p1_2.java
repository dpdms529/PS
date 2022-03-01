package skillChecks;

public class p1_2 {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i = 1;i<=n;i++){
            answer[i-1] = (long)x * i;
        }
        return answer;
    }

	public static void main(String[] args) {
		long[] result = solution(2,5);
		for(long l : result) {
			System.out.println(l);
		}
	}

}
