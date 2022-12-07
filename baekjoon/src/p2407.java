import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class p2407 {
    public static BigInteger factorial(int n){
        if(n<2){
            return BigInteger.ONE;
        }else{
            return BigInteger.valueOf(n).multiply(factorial(n-1));
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger result = factorial(n).divide(factorial(m).multiply(factorial(n-m)));
        System.out.println(result);
    }
}
