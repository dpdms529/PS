import java.util.*;
import java.io.*;

public class p2178 {
    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[][] cnt;
    public static boolean[][] visited;
    public static int[] dy = {0,0,1,-1};
    public static int[] dx = {1,-1,0,0};

    public static void bfs(){
        int y = 0;
        int x = 0;
        Queue<int[]> queue = new LinkedList<>();
        cnt[y][x] = 1;
        visited[y][x] = true;
        queue.offer(new int[]{y,x});
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            y = position[0];
            x = position[1];
            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny>=0 && nx>=0 && ny<n && nx<m && graph.get(ny).get(nx)==1 && !visited[ny][nx]){
                    cnt[ny][nx] = cnt[y][x]+1;
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny,nx});
                }
            }
        }
        System.out.println(cnt[n-1][m-1]);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
            char[] input = br.readLine().toCharArray();
            for(int j = 0;j<m;j++){
                graph.get(i).add(input[j]-'0');
            }
        }
        bfs();
    }
}
