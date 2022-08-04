package p1991;

import java.util.*;
import java.io.*;

class Node{
    char left;
    char right;
    public Node(char left, char right){
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static int n;
    static Node[] graph;
    static StringBuilder sb = new StringBuilder();

    static void preorderTraversal(char x){
        sb.append(x);
        char left = graph[x-'A'].left;
        char right = graph[x-'A'].right;
        if(left != '.') preorderTraversal(left);
        if(right != '.') preorderTraversal(right);
    }

    static void inorderTraversal(char x){
        char left = graph[x-'A'].left;
        char right = graph[x-'A'].right;
        if(left != '.') inorderTraversal(left);
        sb.append(x);
        if(right != '.') inorderTraversal(right);

    }

    static void postOrderTraversal(char x){
        char left = graph[x-'A'].left;
        char right = graph[x-'A'].right;
        if(left!='.') postOrderTraversal(left);
        if(right!='.') postOrderTraversal(right);
        sb.append(x);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new Node[n];
        StringTokenizer st;
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            graph[node-'A'] = new Node(left, right);
        }

        preorderTraversal('A');
        sb.append("\n");
        inorderTraversal('A');
        sb.append("\n");
        postOrderTraversal('A');
        System.out.println(sb);

    }
}
