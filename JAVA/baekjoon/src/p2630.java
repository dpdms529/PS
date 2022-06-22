import java.util.*;
import java.io.*;

public class p2630 {
    public static int[][] graph;
    public static int[] cnt = {0,0};

    public static void divide(int y, int x, int size){
        int item = graph[y][x];
        if(size == 1){
            cnt[item]++;
        }else{
            boolean isSame = true;
            check:for(int i = 0;i<size;i++){
                for(int j = 0;j<size;j++){
                    if(graph[y+i][x+j] != item){
                        isSame = false;
                        break check;
                    }
                }
            }
            if(isSame){
                cnt[item]++;
            }else{
                size = size/2;
                for(int i = 0;i<2;i++){
                    for(int j = 0;j<2;j++){
                        divide(y+i*size, x+j*size, size);
                    }
                }
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,n);
        for(int i = 0;i<2;i++){
            System.out.println(cnt[i]);
        }

    }
}
