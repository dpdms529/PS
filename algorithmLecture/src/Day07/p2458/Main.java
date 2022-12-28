package Day07.p2458;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] in, out;

    static int dfs(int x){
        int out = 0;
        for(int next:graph[x]){
            if(!visited[next]){
                visited[next] = true;
                in[next]++;
                out += dfs(next)+1;
            }
        }
        return out;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        in = new int[N+1];
        out = new int[N+1];

        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for(int i = 1;i<=N;i++){
            visited = new boolean[N+1];
            out[i] = dfs(i);
        }

        int result = 0;
        for(int i = 1;i<=N;i++){
            if(in[i] + out[i] == N-1) result++;
        }

        System.out.println(result);
    }
}
