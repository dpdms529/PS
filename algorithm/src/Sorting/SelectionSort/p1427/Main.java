package Sorting.SelectionSort.p1427;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int arr[] = new int[N.length()];
        for(int i = 0;i<N.length();i++){
            arr[i] = N.charAt(i) - '0';
        }

        for(int i = 0;i<arr.length-1;i++){
            int maxIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = tmp;
        }

        for(int i:arr) System.out.print(i);
    }
}
