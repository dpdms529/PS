import java.util.*;
import java.io.*;

public class p11053 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<i;j++){
                if(a[i]>a[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for(int i : dp){
            if(max<i) max = i;
        }
        System.out.println(max);
    }
}
