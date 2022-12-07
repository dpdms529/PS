import java.util.*;
import java.io.*;

public class p15656 {
    public static int n, m;
    public static int[] numbers;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth){
        if(depth == m){
            for(int i = 0;i<m;i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        }else{
            for(int i = 0;i<n;i++){
                arr[depth] = numbers[i];
                dfs(depth+1);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        dfs(0);
        System.out.println(sb);

    }
}
