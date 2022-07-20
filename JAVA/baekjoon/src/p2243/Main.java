package Day03.p2243;

import java.util.*;
import java.io.*;

public class Main {
    static int N = 1000000;
    static int S = 1;
    static long[] tree;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(S < N){
            S *= 2;
        }
        tree = new long[2*S];

        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){
                int left = 0;
                int right = S;
                int target = 0;
                while(left<=right){
                    int mid = (left+right)/2;
                    long rank = query(1,S,1,1,mid);
                    if(rank<b){
                        left = mid + 1;
                    }else{
                        target = mid;
                        right = mid - 1;
                    }
                }
                System.out.println(target);
                update(1,S,1,target,-1);
            }else{
                long c = Long.parseLong(st.nextToken());
                update(1,S,1,b,c);
            }
        }
    }

    static long query(int left, int right, int node, int start, int end){
        if(end < left || start > right ) return 0;
        else if(start <= left && right <= end) return tree[node];
        else{
            int mid = (left+right)/2;
            long leftResult = query(left, mid, node*2, start, end);
            long rightResult = query(mid+1, right, node*2+1, start, end);
            return leftResult + rightResult;
        }
    }

    static void update(int left, int right, int node, int target, long diff){
        if(target < left || target > right) return;
        else{
            tree[node] += diff;
            if(left!=right){
                int mid = (left+right)/2;
                update(left, mid, node*2, target, diff);
                update(mid+1, right, node*2+1, target, diff);
            }

        }
    }
}
