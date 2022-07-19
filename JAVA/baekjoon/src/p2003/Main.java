package Day02.p2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int cnt = 0;
        while(right<n){
            if(sum < m) {
                right++;
                if(right==n) break;
                sum += arr[right];
            }
            else if(sum==m) {
                cnt++;
                sum -= arr[left];
                left++;
            }
            else {
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(cnt);
    }
}
