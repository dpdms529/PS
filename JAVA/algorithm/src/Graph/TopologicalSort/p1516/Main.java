package Graph.TopologicalSort.p1516;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static int[] times;

    static int[] topologicalSort(){
        int[] result = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<=N;i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : graph[node]){
                indegree[next]--;
                result[next] = Math.max(result[next], result[node]+times[node]);
                if(indegree[next] == 0) queue.offer(next);
            }
        }
        return result;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        times = new int[N+1];
        StringTokenizer st;
        for(int i = 1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;
            int id = Integer.parseInt(st.nextToken());
            while(id != -1){
                graph[id].add(i);
                indegree[i]++;
                id = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = topologicalSort();
        for(int i = 1;i<=N;i++){
            System.out.println(result[i] + times[i]);
        }
    }
}
