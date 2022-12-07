import java.util.*;
import java.io.*;

public class p15649 {
    public static int n;
    public static int m;
    public static boolean visited[];
    public static int arr[];

    public static void dfs(int depth){
        if(depth == m){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<m;i++){
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);

        }else{
            for(int i = 0;i<n;i++){
                if(!visited[i]){
                    visited[i] = true;
                    arr[depth] = i+1;
                    dfs(depth+1);
                    visited[i] = false;
                }
            }
        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[m];
        dfs(0);
    }
}
