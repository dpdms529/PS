package Day04.p14476;

import java.util.*;
import java.io.*;

public class Main {
    static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] A = new int[n];
        int[] B = new int[n];
        A[0] = arr[0];
        B[n-1] = arr[n-1];

        for(int i = 1;i<n;i++){
            A[i] = gcd(A[i-1], arr[i]);
        }

        for(int i = n-2;i>=0;i--){
            B[i] = gcd(B[i+1], arr[i]);

        }

        int max = 0;
        int index = 0;
        for(int i = 0;i<n;i++){
            int gcd = 0;
            if(i==0) gcd = B[1];
            else if(i==n-1) gcd = A[n-2];
            else gcd = gcd(A[i-1], B[i+1]);
            if(arr[i] % gcd != 0 && gcd > max){
                max = gcd;
                index = i;
            }
        }
        if(max==0) System.out.println(-1);
        else System.out.println(max + " " +  arr[index]);

    }
}
