package p2357;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] nums;
    static MinMax[] tree;
    static int S = 1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        for(int i = 0;i<N;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        while(S < N){
            S *= 2;
        }

        tree = new MinMax[2*S];
        Arrays.fill(tree, new MinMax(Integer.MAX_VALUE, 0));

        init();

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(query(1, S, 1, a, b));
        }

    }

    static void init(){
        for(int i = 0;i<N;i++){
            tree[S+i] = new MinMax(nums[i], nums[i]);
        }

        for(int i = S-1;i>0;i--){
            tree[i] = new MinMax(Math.min(tree[i*2].min, tree[i*2+1].min), Math.max(tree[i*2].max, tree[i*2+1].max));
        }
    }

    static MinMax query(int left, int right, int node, int start, int end){
        if(start > right || end < left) return new MinMax(Integer.MAX_VALUE, 0);
        else if(start <= left && end >= right) return tree[node];
        else{
            int mid = (left + right) / 2;
            MinMax leftResult = query(left, mid, node*2, start, end);
            MinMax rightResult = query(mid+1, right, node*2+1, start, end);
            return new MinMax(Math.min(leftResult.min, rightResult.min), Math.max(leftResult.max, rightResult.max));
        }
    }
}

class MinMax{
    int min;
    int max;

    MinMax(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return min + " " + max;
    }
}
