import java.util.*;
import java.io.*;

public class p10026 {
    static int n;
    static ArrayList<ArrayList<Character>> graph = new ArrayList<>();
    static boolean visited[][];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};

    public static void bfs(int i, int j, boolean isNormal){
        int y = i;
        int x = j;
        char c = graph.get(y).get(x);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int pos[] = queue.poll();
            y = pos[0];
            x = pos[1];
            for(int d = 0;d<4;d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                if(ny>=0 && nx>=0 && ny<n && nx<n){
                    char nc = graph.get(ny).get(nx);
                    if(!visited[ny][nx]){
                        if(isNormal && c==nc){
                            queue.offer(new int[]{ny,nx});
                            visited[ny][nx] = true;
                        }else if(!isNormal){
                            if(c=='B' && c==nc){
                                queue.offer(new int[]{ny,nx});
                                visited[ny][nx] = true;
                            }else if(c!='B' && nc!='B'){
                                queue.offer(new int[]{ny,nx});
                                visited[ny][nx] = true;
                            }
                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++){
            char input[] = br.readLine().toCharArray();
            graph.add(new ArrayList<>());
            for(int j = 0;j<n;j++){
                graph.get(i).add(input[j]);
            }
        }

        int cntNormal = 0;
        int cntNotNormal = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j, true);
                    cntNormal++;
                }
            }
        }
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j]){
                    bfs(i,j, false);
                    cntNotNormal++;
                }
            }
        }
        System.out.println(cntNormal + " " + cntNotNormal);

    }
}
