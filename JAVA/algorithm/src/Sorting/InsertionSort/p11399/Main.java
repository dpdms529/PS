package Sorting.InsertionSort.p11399;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1;i<N;i++){
            int index = i;
            int j = i-1;
            while(j>=0 && arr[index] < arr[j]){
                int tmp = arr[index];
                arr[index] = arr[j];
                arr[j] = tmp;
                index = j--;
            }
        }

        int sum = arr[0];
        for(int i = 1;i<N;i++){
            arr[i] += arr[i-1];
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
