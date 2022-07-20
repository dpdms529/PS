package p2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k;
    static long[] nums;
    static long[] tree;
    static int s = 1;

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
        while(s<n){
            s*=2;
        }
        tree = new long[2*s];
        init();

        for(int i = 0;i<m+k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==1){
                long c = Long.parseLong(st.nextToken());
                long diff = c - query(1,s,1,b,b);
                update(1,s,1,b,diff);
            }else{
                int c = Integer.parseInt(st.nextToken());
                System.out.println(query(1,s,1,b,c));
            }
        }

    }

    static void init(){
        for(int i = 0;i<n;i++){
            tree[s+i] = nums[i];
        }
        for(int i = s-1;i>0;i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    static long query(int left, int right, int node, int start, int end){
        if(start > right || end < left) return 0;
        else if(start<=left && end>=right) return tree[node];
        else{
            int mid = (left+right)/2;
            long leftResult = query(left, mid, node*2, start, end);
            long rightResult = query(mid+1, right, node*2+1, start, end);
            return leftResult + rightResult;
        }
    }

    static void update(int left, int right, int node, int target, long diff){
        if(target<left || target>right) return;
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
