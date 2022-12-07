package p1725;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long[] height;
    static long[] indexedTree;
    static int S = 1;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        height = new long[N];
        indexedTree = new long[2*N];
        while (S < N) {
            S *= 2;
        }
        for(int i = 0;i<N;i++){
            height[i] = Long.parseLong(br.readLine());
            indexedTree[S+i] = height[i];
        }
        for(int i = S-1; i>=0; i--){
            indexedTree[i] = Math.min(indexedTree[i*2], indexedTree[i*2+1]);
        }



    }

    static long query(int left, int right, int node, int queryLeft, int queryRight){
        if(queryLeft > right || queryRight < left) return (long)1e9;
        else if(queryLeft<=left && right<=queryRight){
            return indexedTree[node];
        }else{
            int mid = (left+right)/2;
            long resultLeft = query(left, mid, node*2, queryLeft, queryRight);
            long resultRight = query(mid+1, right, node*2+1, queryLeft, queryRight);
            return Math.min(resultLeft, resultRight);
        }
    }

}
