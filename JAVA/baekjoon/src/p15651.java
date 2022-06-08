import java.util.*;
import java.io.*;

public class p15651 {
    public static int n;
    public static int m;
    public static int arr[];
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth){
        if(m==depth){
            for(int i = 0;i<m;i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }else{
            for(int i = 0;i<n;i++){
                arr[depth] = i+1;
                dfs(depth+1);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0);
        System.out.println(sb);
    }
}
