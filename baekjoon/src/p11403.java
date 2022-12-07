import java.util.*;
import java.io.*;

public class p11403 {
    public static int n;
    public static int[][] graph;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                int path = Integer.parseInt(st.nextToken());
                if(path==1) graph[i][j] = 1;
                else graph[i][j] = 10001;
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<n;k++){
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(graph[i][j] == 10001) sb.append(0 + " ");
                else sb.append(1 + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
