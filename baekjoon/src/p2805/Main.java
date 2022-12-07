package p2805;

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
        int max = 0;
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>max) max = arr[i];
        }
        long start = 0;
        long end = max;
        long result = 0;
        while(start <= end){
            long sum = 0;
            long height = (start+end)/2;
            for(int i : arr){
                if(i>height) sum += i-height;
            }
            if(sum<m){
                end = height-1;
            }else if(sum==m){
                result = height;
                break;
            }else{
                result = height;
                start = height+1;
            }
        }
        System.out.println(result);

    }
}
