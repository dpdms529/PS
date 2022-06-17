import java.util.*;
import java.io.*;

public class p2667 {
    public static int n;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean visited[][];
    public static int[] dy = {0,0,1,-1};
    public static int[] dx = {1,-1,0,0};

    public static int bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        visited[y][x] = true;
        queue.offer(new int[]{y,x});
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            y = position[0];
            x = position[1];
            cnt++;
            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny>=0 && nx>=0 && ny<n && nx<n && graph.get(ny).get(nx)==1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny,nx});
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited  = new boolean[n][n];
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
            char[] input = br.readLine().toCharArray();
            for(int j = 0;j<n;j++){
                graph.get(i).add(input[j]-'0');
            }
        }
        ArrayList<Integer> cnt = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(graph.get(i).get(j)==1 && !visited[i][j]){
                    cnt.add(bfs(i,j));
                }
            }
        }
        Collections.sort(cnt);
        System.out.println(cnt.size());
        for(int i:cnt){
            System.out.println(i);
        }
    }
}
