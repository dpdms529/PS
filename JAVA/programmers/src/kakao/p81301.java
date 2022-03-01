package kakao;

public class p81301 {
    static String num[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public static int solution(String s) {
    	for(int i = 0;i<10;i++) {
    		s = s.replaceAll(num[i], i+"");
    	}
        int answer = Integer.parseInt(s);
        return answer;
    }
    
    public static void main(String[] args) {
    	System.out.println(solution("one4seveneight"));
    	System.out.println(solution("23four5six7"));
    	System.out.println(solution("2three45sixseven"));
    	System.out.println(solution("123"));
	}
}