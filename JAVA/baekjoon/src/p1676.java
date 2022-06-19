import java.math.BigInteger;
import java.io.*;

public class p1676 {
    // factorial(n) : n!을 구하는 함수
    public static BigInteger factorial(int n){
        // n<2일 경우 1 리턴
        // n>=2일 경우 n * factorial(n-1) 리턴
        if(n<2){
            return BigInteger.ONE;
        }else{
            return BigInteger.valueOf(n).multiply(factorial(n-1));
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // n : 팩토리얼을 구할 숫자
        int n = Integer.parseInt(br.readLine());
        
        // f : n!의 값
        BigInteger f = factorial(n);
        
        // cnt : n!에서 뒤에서부터 처음으로 0이 아닌 숫자가 나올 때까지의 0의 개수
        int cnt = 0;
        
        // 0이 아닌 숫자가 나올 때까지 f를 10으로 나누면서 cnt값 1씩 증가
        while(f.remainder(BigInteger.TEN).equals(BigInteger.ZERO)){
            cnt++;
            f = f.divide(BigInteger.TEN);
        }
        
        // cnt 출력
        System.out.println(cnt);
    }
}
