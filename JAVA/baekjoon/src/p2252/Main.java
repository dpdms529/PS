package p2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] degree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();


    static void topologicalSort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<=N;i++){
            if(degree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int item = queue.poll();
            for(int i = 0;i<graph.get(item).size();i++){
                int successor = graph.get(item).get(i);
                degree[successor]--;
                if(degree[successor]==0) queue.offer(successor);
            }
            sb.append(item + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degree = new int[N+1];
        for(int i = 0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            degree[b]++;
        }

        topologicalSort();
    }
}
