package 자료구조;

import java.io.*;
import java.util.*;

public class p1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int result = 0;
        for(int k = 0;k<n;k++){
            int find = arr[k];
            int i = 0;
            int j = n-1;
            while(i<j){
                if(arr[i] + arr[j] == find){
                    if(i!=k && j!=k){
                        result++;
                        break;
                    }else if(i == k){
                        i++;
                    }else if(j == k){
                        j--;
                    }
                }else if(arr[i] + arr[j] < find){
                    i++;
                }else{
                    j--;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}
