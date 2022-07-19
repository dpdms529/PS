package p1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = y*100/x;
        long start = 0;
        long end = x;
        long result = -1;
        while(start<=end){
            long mid = (start+end)/2;
            long total = x + mid;
            long win = y + mid;
            long rate = win*100/total;
            if(rate==z){
                start = mid+1;
            }else{
                result = mid;
                end = mid-1;
            }
        }
        System.out.println(result);
    }
}
