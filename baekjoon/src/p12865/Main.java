package p12865;

import java.util.*;
import java.io.*;

class Item{
    int w;
    int v;
    public Item(int w, int v){
        this.w = w;
        this.v = v;
    }
}

public class Main {
    static int N, K;
    static int[][] dp;
    static Item[] items;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        items = new Item[N+1];

        for(int i = 1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i] = new Item(w,v);
        }

        for(int i = 1;i<=N;i++){
            for(int j = 1;j<=K;j++){
                if(items[i].w <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i].w] + items[i].v);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
