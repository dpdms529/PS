package Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9663 {
    public static int n;
    public static int[] arr;
    public static int cnt = 0;

    public static boolean check(int depth, int x){
        for(int i = 0;i<depth;i++){
            if(x==arr[i]) return false;
            if(Math.abs(depth-i)==Math.abs(x-arr[i])) return false;
        }
        return true;
    }

    public static void dfs(int depth){
        if(depth==n){
            cnt++;
        }else{
            for(int i = 0;i<n;i++){
                if(check(depth, i)){
                    arr[depth] = i;
                    dfs(depth+1);
                }
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);
        System.out.println(cnt);
    }
}
