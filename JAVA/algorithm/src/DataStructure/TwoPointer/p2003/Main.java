package DataStructure.TwoPointer.p2003;

import java.util.*;
import java.io.*;

public class Main {
    static int twoPointer(int[] arr, int target){
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int cnt = 0;
        while(right < arr.length){
            if(sum == target){
                cnt++;
                right++;
                if(right<arr.length) sum += arr[right];
            }else if(sum < target){
                right++;
                if(right<arr.length) sum += arr[right];
            }else{
                sum -= arr[left];
                left++;
            }
        }
        return cnt;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(twoPointer(arr, M));
    }
}
