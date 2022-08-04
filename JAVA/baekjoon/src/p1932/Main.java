package p1932;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int total = n * (n+1) / 2;
        int[] nums = new int[total+1];
        int[] dp = new int[total+1];
        int index = total;
        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<i;j++){
                nums[index--] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1;i<=n;i++){
            dp[i] = nums[i];
        }

        int start = n+1;
        for(int i = n;i>1;i--){
            for(int j = start; j<start+i-1; j++){
                dp[j] = Math.max(dp[j-i], dp[j-i+1]) + nums[j];
            }
            start += i-1;
        }
        System.out.println(dp[total]);
    }
}
