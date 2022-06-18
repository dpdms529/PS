import java.util.*;
import java.io.*;

public class p11724 {
    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int i = 0;i<graph.get(x).size();i++){
                int y = graph.get(x).get(i);
                if(!visited[y]){
                    visited[y] = true;
                    queue.offer(y);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cnt = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}