package Day02.p3955;

import java.util.*;
import java.io.*;

class EGResult{
    long s;
    long t;
    long r;
    public EGResult(long s, long t, long r){
        super();
        this.s = s;
        this. t = t;
        this.r = r;
    }
}

public class Main {

    static EGResult extendedGcd(long a, long b){
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while(r1 != 0){
            long q = r0 / r1;
            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }

        return new EGResult(s0, t0, r0);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            EGResult result = extendedGcd(a,b);
            if(result.r != 1) System.out.println("IMPOSSIBLE");
            else{
                long x0 = result.s;
                long y0 = result.t;

                long kFromY = (long)Math.ceil((double) y0 / (double) a) - 1;
                long kFromX = (long)Math.ceil((double) -x0 / (double) b) - 1;
                long k = Math.min(kFromX, kFromY);
                long kLimitFromY = (long)Math.ceil((y0 - 1e9) / (double)a);
                if(kLimitFromY <= k){
                    System.out.println(y0 - a * k);
                }else{
                    System.out.println("IMPOSSIBLE");
                }
            }
        }
    }
}
