import java.util.*;
import java.io.*;

public class p16928 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] graph = new int[101];
        int[] cnt = new int[101];
        boolean[] visited = new boolean[101];

        for(int i = 0;i<n+m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x] = y;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.offer(1);
        while(!queue.isEmpty()){
            int pos = queue.poll();
            for(int i = 1;i<=6;i++){
                int next = pos + i;
                if(next<101 && !visited[next]){
                    visited[next] = true;
                    cnt[next] = cnt[pos] + 1;
                    if(graph[next]!=0) {
                        int tmp = graph[next];
                        while(!visited[tmp] && graph[tmp]!=0){
                            visited[tmp] = true;
                            cnt[tmp] = cnt[pos] + 1;
                            tmp = graph[tmp];
                        }
                        if(!visited[tmp]){
                            visited[tmp] = true;
                            cnt[tmp] = cnt[pos] + 1;
                            queue.offer(tmp);
                        }
                    }
                    else {
                        queue.offer(next);
                    }
                }
            }
        }
        System.out.println(cnt[100]);
    }
}
