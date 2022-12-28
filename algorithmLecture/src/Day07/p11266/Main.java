package Day07.p11266;

import java.util.*;
import java.io.*;

public class Main {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int[] order;
    static boolean[] isDisConnect;
    static int index;

    static int dfs(int x, boolean isRoot){
        order[x] = ++index;
        int result = index;
        int child = 0;
        for(int next:graph[x]){
            if(order[next]==0){
                child++;
                int low = dfs(next, false);
                if(!isRoot && low >= order[x]){
                    isDisConnect[x] = true;
                }
                result = Math.min(result, low);
            }else{
                result = Math.min(result, order[next]);
            }
        }
        if(isRoot && child > 1){
            isDisConnect[x] = true;
        }
        return result;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        order = new int[V+1];
        isDisConnect = new boolean[V+1];

        for(int i = 1;i<=V;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1;i<=V;i++){
            if(order[i] == 0){
                dfs(i, true);
            }
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for(int i = 1;i<=V;i++){
            if(isDisConnect[i]) cnt++;
        }
        sb.append(cnt + "\n");

        for(int i = 1;i<=V;i++){
            if(isDisConnect[i]){
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }
}
