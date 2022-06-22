import java.util.*;
import java.io.*;

public class p16236 {
    public static int n;
    public static int[][] graph;
    public static int[][] cnt;
    public static boolean[][] visited;
    public static int[] dy = {-1,0,0,1};
    public static int[] dx = {0,-1,1,0};
    public static int size = 2;
    public static int[] total = new int[7];

    public static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        graph[y][x] = 0;
        queue.offer(new int[]{y,x});
        int fish = 0;
        while(!queue.isEmpty()){
            int[] item = queue.poll();
            y = item[0];
            x = item[1];
            int totalSum = 0;
            for(int i = 1;i<Math.min(size,7);i++){
                totalSum += total[i];
            }
            if(totalSum==0) break;
            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny>=0 && nx>=0 && ny<n && nx<n){
                    if(graph[ny][nx]<=size && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        cnt[ny][nx] = cnt[y][x] + 1;
                        queue.offer(new int[]{ny, nx});
                        if(graph[ny][nx]>0 && graph[ny][nx]<size){
                            fish++;
                            total[graph[ny][nx]]--;
                            graph[ny][nx] = 0;
                            queue.clear();
                            visited = new boolean[n][n];
                            visited[ny][nx] = true;
                            queue.offer(new int[]{ny, nx});
                            System.out.println(ny + " " +  nx + " " + cnt[ny][nx]);
                            if(fish==size) {
                                size++;
                                fish=0;
                            }
                            break;
                        }
                    }
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(cnt[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("size : " + size + "fish : " + fish);
        if(size==2 && fish==0) System.out.println(0);
        else System.out.println(cnt[y][x]);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        cnt = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;
        int y = 0;
        int x = 0;
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 9){
                    y = i;
                    x = j;
                }else if(graph[i][j]>0){
                    total[graph[i][j]]++;
                }
            }
        }
        bfs(y,x);
    }
}
