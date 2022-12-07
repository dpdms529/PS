import java.util.*;
import java.io.*;

public class p6064 {
    public static int gcd(int a, int b){
        int r = a%b;
        if(r==0) return b;
        else return gcd(b,r);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int last = m*n/gcd(m,n);
            int result = -1;
            for(int j = 0;j<last;j+=m){
                int tmp = j + x;
                if(tmp%n == y || (y == n && tmp%n == 0)){
                    result = tmp;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
