import java.util.*;
import java.io.*;

public class p14502 {
    public static int n, m;
    public static int[][] graph;
    public static int[][] origin;
    public static ArrayList<int[]> virus = new ArrayList<>();
    public static ArrayList<int[]> empty = new ArrayList<>();
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};
    public static Queue<int[]> queue = new LinkedList<>();

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];
            for(int i = 0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny>=0 && ny<n && nx>=0 && nx<m && graph[ny][nx]==0){
                    graph[ny][nx] = 2;
                    queue.offer(new int[]{ny,nx});
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        origin = new int[n][m];
        int max = 0;

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                origin[i][j] = Integer.parseInt(st.nextToken());
                graph[i][j] = origin[i][j];
                if(origin[i][j]==0) empty.add(new int[]{i,j});
                if(origin[i][j]==2) virus.add(new int[]{i,j});
            }
        }
        int size = empty.size();
        for(int i = 0;i<size-2;i++){
            for(int j = i+1;j<size-1;j++){
                for(int k = j+1;k<size;k++){
                    graph[empty.get(i)[0]][empty.get(i)[1]] = 1;
                    graph[empty.get(j)[0]][empty.get(j)[1]] = 1;
                    graph[empty.get(k)[0]][empty.get(k)[1]] = 1;
                    for(int l = 0;l<virus.size();l++){
                        int[] vpos = virus.get(l);
                        queue.offer(new int[]{vpos[0],vpos[1]});
                    }
                    bfs();
                    int cnt = 0;
                    for(int a = 0;a<n;a++){
                        for(int b = 0;b<m;b++){
                            if(graph[a][b] == 0) cnt++;
                        }
                    }
                    if(cnt > max) max = cnt;
                    for(int a = 0;a<n;a++){
                        for(int b = 0;b<m;b++){
                            graph[a][b] = origin[a][b];
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
