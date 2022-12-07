import java.util.*;
import java.io.*;

public class p1389 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i!=j) graph[i][j] = 101;
            }
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        int[] kb = new int[n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                kb[i] += graph[i][j];
            }
        }
        int min = 0;
        for(int i = 1;i<n;i++){
            if(kb[i]<kb[min]) min = i;
        }
        System.out.println(min+1);

    }
}
