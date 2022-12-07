import java.util.*;
import java.io.*;

public class p15652 {
    public static int n;
    public static int m;
    public static int arr[];
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth){
        if(depth==m+1){
            for(int i = 1;i<=m;i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }else{
            for(int i = 1;i<=n;i++){
                if(arr[depth-1]<=i){
                    arr[depth] = i;
                    dfs(depth+1);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1];
        dfs(1);
        System.out.println(sb);
    }
}
