import java.io.*;

public class p17626 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n+1];
        graph[1] = 1;
        for(int i = 2;i<=n;i++){
            graph[i] = Integer.MAX_VALUE;
        }
        for(int i = 2;i<=n;i++){
            for(int j = 1;j*j<=i;j++){
                graph[i] = Math.min(graph[i], graph[i-j*j]);
            }
            graph[i]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(graph[n]));
        bw.flush();
        br.close();
        bw.close();
    }
}
