package p1629;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(pow(a,b,c));
    }

    public static long pow(long a, long b, long c){
        if(b==1){
            return a%c;
        }else{
            long x = pow(a, b/2, c);
            long result = x * x % c;
            if(b%2==0){
                return result;
            }else{
                return result * a % c;
            }
        }
    }
}
