import java.io.*;

public class p9663 {
    public static int n;
    public static int[] arr;
    public static int cnt = 0;

    public static void dfs(int depth){
        if(depth==n){
            cnt++;
        }else{
            for(int i = 0;i<n;i++){
                boolean check = true;
                arr[depth] = i;
                for(int j = 0;j<depth;j++){
                    if(arr[depth]==arr[j]) check = false;
                    else if(Math.abs(depth-j) == Math.abs(arr[depth]-arr[j])) check = false;
                }
                if(check){
                    dfs(depth+1);
                }
            }

        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);
        System.out.println(cnt);
    }
}
