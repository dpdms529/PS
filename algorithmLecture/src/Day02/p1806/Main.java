package Day02.p1806;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int min = n+1;
        while(true){
            if(sum >= s){
                int len = right - left + 1;
                min = Math.min(min, len);
                sum -= arr[left++];
            }else{
                if(++right==n) break;
                sum += arr[right];
            }
        }
        if(min==n+1) System.out.println(0);
        else System.out.println(min);
    }
}
