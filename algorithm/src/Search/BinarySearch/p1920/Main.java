package Search.BinarySearch.p1920;

import java.util.*;
import java.io.*;

public class Main {
    static int[] A;
    static void binarySearch(int start, int end, int target){
        if(start > end) System.out.println(0);
        else{
            int mid = (start + end) / 2;

            if(A[mid] == target) System.out.println(1);
            else if(A[mid] > target) binarySearch(start, mid-1, target);
            else binarySearch(mid+1, end, target);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<M;i++){
            int target = Integer.parseInt(st.nextToken());
            binarySearch(0, N-1, target);
        }
    }
}
