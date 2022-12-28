package Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1920 {
    public static int[] A;
    public static int find(int start, int end, int x){
        while(start<=end){
            int mid = (start+end)/2;
            if(A[mid]>x) end = mid-1;
            else if(A[mid]==x) return 1;
            else start = mid+1;
        }
        return 0;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            System.out.println(find(0,n-1,num));
        }
    }
}
