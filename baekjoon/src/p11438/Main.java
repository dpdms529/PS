package p11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[][] dp;
    static int[] depth;
    static boolean[] visited;
    static int maxDepth = 0;

    static void getDepthAndParent(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 0;i<graph[cur].size();i++){
                int next = graph[cur].get(i);
                if(!visited[next]){
                    dp[0][next] = cur;
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }

    static int lca(int a, int b){
        if(depth[a]>depth[b]){
            int tmp = b;
            b = a;
            a = tmp;
        }
        int gap = depth[b] - depth[a];
        for(int i = 0;i<=17;i++){
            if((gap & (1 << i)) > 0){
                b = dp[i][b];
            }
        }
        if(a==b) return a;
        for(int i = 17; i>=0; i--){
            if(dp[i][a]!=dp[i][b]){
                a = dp[i][a];
                b = dp[i][b];
            }
        }
        return dp[0][a];
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        dp = new int[18][N+1];
        depth = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        getDepthAndParent();

        for(int i = 1;i<=17;i++){
            for(int j = 1;j<=N;j++){
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a,b) + "\n");
        }
        System.out.println(sb);

    }
}
