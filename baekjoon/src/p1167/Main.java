package p1167;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int V;
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    static int farthest = 0;

    public static void main(String[] args) throws IOException{
        init();

        visited = new boolean[V+1];
        dfs(new Node(1,0));

        visited = new boolean[V+1];
        dfs(new Node(farthest, 0));

        System.out.println(max);
    }

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];

        for(int i = 1;i<=V;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0;i<V;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int dist;

            while(next != -1){
                dist = Integer.parseInt(st.nextToken());
                tree[node].add(new Node(next, dist));
                next = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    public static void dfs(Node node){
        if(node.dist > max){
            max = node.dist;
            farthest = node.num;
        }

        visited[node.num] = true;

        for(Node next : tree[node.num]){
            if(!visited[next.num]){
                dfs(new Node(next.num, node.dist + next.dist));
            }
        }
    }
}

class Node{
    int num;
    int dist;

    public Node(int num, int dist){
        this.num = num;
        this.dist = dist;
    }
}
