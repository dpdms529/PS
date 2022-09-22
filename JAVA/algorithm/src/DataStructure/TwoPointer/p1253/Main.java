package DataStructure.TwoPointer.p1253;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for(int i = 0;i<N;i++){
            int start = 0;
            int end = N-1;
            while(start < end){
                if(arr[start] + arr[end] == arr[i]){
                    if(start != i && end != i){
                        cnt++;
                        break;
                    }else if(start == i){
                        start++;
                    }else if( end == i){
                        end--;
                    }
                }else if(arr[start] + arr[end] < arr[i]){
                    start++;
                }else{
                    end--;
                }
            }
        }
        System.out.println(cnt);
    }
}
