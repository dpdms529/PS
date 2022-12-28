package Day03.p2042;

import java.util.*;
import java.io.*;

public class IndexedTree {
    public static int n,m,k;
    public static long[] nums;
    public static long[] tree;
    public static int s;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new long[n];

        for(int i = 0;i<n;i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        s = 1;
        while(s<n){
            s *= 2;
        }
        tree = new long[s*2];
    }

    static void initBU(){
        for(int i = 0;i<n;i++){
            tree[s+i] = nums[i];
        }
        for(int i = s-1;i>0;i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight){
        if(queryRight < left || right < queryLeft){
            return 0;
        }else if(queryLeft <= left && right <=queryRight){
            return tree[node];
        }else{
            int mid = (left+right)/2;
            long resultLeft = query(left, mid, node*2, queryLeft, queryRight);
            long resultRight = query(mid+1, right, node*2+1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }

    static void update(int left, int right, int node, int target, long diff){
        if(target < left || right < target){
            return;
        }else{
            tree[node] += diff;
            if(left!=right){
                int mid = (left+right)/2;
                update(left, mid, node*2, target, diff);
                update(mid+1, right, node*2+1, target, diff);
            }
        }
    }

    static long queryBU(int queryLeft, int queryRight){
        int left = s + queryLeft - 1;
        int right = s + queryRight - 1;
        long sum = 0;
        while(left <= right){
            if(left % 2 == 1){
                sum += tree[left++];
            }
            if(right % 2 == 0){
                sum += tree[right--];
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    static void updateBU(int target, long value){
        int node = s + target - 1;
        tree[node] = value;
        node /= 2;
        while(node>0){
            tree[node] = tree[node*2] + tree[node*2+1];
            node /= 2;
        }
    }
}
