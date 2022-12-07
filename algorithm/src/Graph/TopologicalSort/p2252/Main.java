package Graph.TopologicalSort.p2252;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] graph;

    static ArrayList<Integer> topologicalSort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<=N;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : graph[node]){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
            result.add(node);
        }
        return result;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i = 1;i<=N;i++){
            graph[i] = new ArrayList();
        }
        indegree = new int[N+1];

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int tall = Integer.parseInt(st.nextToken());
            graph[small].add(tall);
            indegree[tall]++;
        }

        ArrayList<Integer> result = topologicalSort();
        for(int i : result) System.out.print(i + " ");
    }
}
