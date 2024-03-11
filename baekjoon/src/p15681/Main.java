package p15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static ArrayList<Integer>[] graph;
    static Node root;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        root = new Node(R);
        size = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph[U].add(V);
            graph[V].add(U);
        }

        makeTree(root);

        countSubTreeNodes(root);

        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            System.out.println(size[U]);
        }

    }

    static void makeTree(Node current) {
        for (int next : graph[current.id]) {
            if(current.parent == null || next != current.parent.id) {
                Node child = new Node(next, current);
                current.children.add(child);
                makeTree(child);
            }
        }
    }

    static void countSubTreeNodes(Node current) {
        size[current.id] = 1;

        for (Node child : current.children) {
            countSubTreeNodes(child);
            size[current.id] += size[child.id];
        }
    }

}

class Node {
    int id;
    Node parent;
    ArrayList<Node> children = new ArrayList<>();

    public Node(int id) {
        this(id, null);
    }

    public Node(int id, Node parent) {
        this.id = id;
        this.parent = parent;
    }
}
