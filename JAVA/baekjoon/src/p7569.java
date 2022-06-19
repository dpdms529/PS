import java.util.*;
import java.io.*;

public class p7569 {
    public static int m;
    public static int n;
    public static int h;
    public static ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
    public static Queue<int[]> queue = new LinkedList<>();
    public static int[] dz = {1,-1,0,0,0,0};
    public static int[] dy = {0,0,0,0,1,-1};
    public static int[] dx = {0,0,1,-1,0,0};

    public static int bfs(){
        int z = -1;
        int y = -1;
        int x = -1;
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            z = position[0];
            y = position[1];
            x = position[2];
            for(int i = 0;i<6;i++){
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(nz>=0 && ny>=0 && nx>=0 && nz<h && ny<n && nx<m){
                    if(graph.get(nz).get(ny).get(nx)==0){
                        graph.get(nz).get(ny).set(nx, graph.get(z).get(y).get(x)+1);
                        queue.offer(new int[]{nz,ny,nx});
                    }
                }
            }
        }
        return graph.get(z).get(y).get(x)-1;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        for(int i = 0;i<h;i++){
            graph.add(new ArrayList<>());
            for(int j = 0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                graph.get(i).add(new ArrayList<>());
                for(int k = 0;k<m;k++){
                    graph.get(i).get(j).add(Integer.parseInt(st.nextToken()));
                    if(graph.get(i).get(j).get(k)==1){
                        queue.offer(new int[]{i,j,k});
                    }
                }
            }
        }
        int result = -1;
        if(!queue.isEmpty()){
            result = bfs();
        }
        check : for(int i = 0;i<h;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<m;k++){
                    if(graph.get(i).get(j).get(k) == 0){
                        result = -1;
                        break check;
                    }
                }
            }
        }
        System.out.println(result);

    }
}
