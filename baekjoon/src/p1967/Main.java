package p1967;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max;
    static int farthestNode;

    public static void main(String[] args)throws IOException{
        init();

        visited = new boolean[N+1];
        dfs(new Node(1, 0));

        visited = new boolean[N+1];
        dfs(new Node(farthestNode, 0));

        System.out.println(max);
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];

        for(int i = 0;i<=N;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, cost));
            tree[child].add(new Node(parent, cost));
        }

        br.close();
    }

    public static void dfs(Node node){
        if(node.cost > max){
            max = node.cost;
            farthestNode = node.num;
        }

        visited[node.num] = true;

        for(Node next : tree[node.num]){
            if(!visited[next.num]){
                dfs(new Node(next.num, node.cost + next.cost));
            }
        }
    }
}

class Node{
    int num;
    int cost;

    public Node(int num, int cost){
        this.num = num;
        this.cost = cost;
    }
}
