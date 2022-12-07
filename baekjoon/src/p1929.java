import java.util.*;
import java.io.*;

public class p1929 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean isPrime[] = new boolean[n+1];
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i = 2;i*i<=n;i++){
            if(!isPrime[i]){
                for(int j = i*i;j<=n;j+=i){
                    isPrime[j] = true;
                }
            }
        }
        for(int i = m;i<=n;i++){
            if(!isPrime[i]) System.out.println(i);
        }

    }
}
