import java.util.*;
import java.io.*;

public class p1780 {
    public static int[][] graph;
    public static int[] cnt = {0,0,0};

    public static void divide(int y, int x, int size){
        if(size == 1){
            int item = graph[y][x];
            cnt[item+1]++;
        }else{
            int item = graph[y][x];
            boolean isSame = true;
            check : for(int i = 0;i<size;i++){
                for(int j = 0;j<size;j++){
                    if(graph[y+i][x+j]!=item){
                        isSame = false;
                        break check;
                    }
                }
            }
            if(isSame){
                cnt[item+1]++;
            }else{
                size = size / 3;
                for(int i = 0;i<3;i++){
                    for(int j = 0;j<3;j++){
                        divide(y+size*i, x+size*j,size);
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[n][n];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);

        for(int i = 0;i<3;i++){
            System.out.println(cnt[i]);
        }
    }
}
