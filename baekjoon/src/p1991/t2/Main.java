package p1991.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new Node[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            graph[node - 'A'] = new Node(left, right);
        }

        preorderTraversal('A');
        sb.append("\n");
        inorderTraversal('A');
        sb.append("\n");
        postorderTraversal('A');

        System.out.println(sb);

    }

    static void preorderTraversal(char node) {
        char left = graph[node - 'A'].left;
        char right = graph[node - 'A'].right;

        sb.append(node);

        if (left != '.') {
            preorderTraversal(left);
        }

        if (right != '.') {
            preorderTraversal(right);
        }
    }

    static void inorderTraversal(char node) {
        char left = graph[node - 'A'].left;
        char right = graph[node - 'A'].right;

        if (left != '.') {
            inorderTraversal(left);
        }

        sb.append(node);

        if (right != '.') {
            inorderTraversal(right);
        }

    }

    static void postorderTraversal(char node) {
        char left = graph[node - 'A'].left;
        char right = graph[node - 'A'].right;

        if (left != '.') {
            postorderTraversal(left);
        }

        if (right != '.') {
            postorderTraversal(right);
        }

        sb.append(node);
    }
}

class Node {
    char left;
    char right;

    public Node(char left, char right) {
        this.left = left;
        this.right = right;
    }
}