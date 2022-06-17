import java.util.*;
import java.io.*;

public class p11047 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i = n-1;i>=0;i--){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int coin:coins){
            if(coin<=k){
                cnt += k/coin;
                k = k%coin;
            }
            if(k==0) break;
        }
        System.out.println(cnt);
    }
}
