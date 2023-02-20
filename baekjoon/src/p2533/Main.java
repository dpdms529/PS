package p2533;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        dp = new int[N+1][2];

        for(int i = 1;i<=N;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));


    }

    static void dfs(int idx){
        visited[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        for(int child : tree[idx]){
            if(!visited[child]){
                dfs(child);
                //부모가 얼리어답터가 아닐 경우 : 자식은 얼리어답터
                dp[idx][0] += dp[child][1];
                //부모가 얼리어답터일 경우 : 자식은 얼리어답터일 수도 있고 아닐 수도 있음
                //자식이 얼리어답터인 경우와 아닌 경우 중 얼리어답터의 수가 최소인 것 선택
                dp[idx][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
