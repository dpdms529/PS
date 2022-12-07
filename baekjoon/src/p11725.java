import java.util.*;
import java.io.*;

public class p11725 {
    public static int n;
    public static ArrayList<Integer>[] graph;
    public static int[] parentArray;

    public static void dfs(int n, int parent){
        for(int i = 0;i<graph[n].size();i++){
            if(graph[n].get(i)!=parent){
                parentArray[graph[n].get(i)] = n;
                dfs(graph[n].get(i), n);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        parentArray = new int[n+1];
        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1,0);

        for(int i = 2;i<=n;i++){
            System.out.println(parentArray[i]);
        }
    }
}
