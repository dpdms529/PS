import java.util.*;
import java.io.*;

public class p15650 {
    public static int n;
    public static int m;
    public static boolean visited[];
    public static int arr[];

    public static void dfs(int depth){
        if(depth==m+1){
            StringBuilder sb = new StringBuilder();
            for(int i = 1;i<=m;i++){
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
            return;
        }else{
            for(int i = 1;i<=n;i++){
                if(!visited[i] && arr[depth-1]<i){
                    visited[i] = true;
                    arr[depth] = i;
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
        visited = new boolean[n+1];
        arr = new int[m+1];
        dfs(1);

    }
}
