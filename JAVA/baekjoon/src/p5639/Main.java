package p5639;

import java.io.*;

class Node{
    int value;
    Node parent;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        Node node = root;
        String input = br.readLine();
        while(input != null && !input.isEmpty()){
            int num = Integer.parseInt(input);
            if(num < node.value){
                node.left = new Node(num);
                node.left.parent = node;
                node = node.left;
            }else{
                Node tmp = node;
                while(tmp != root && num > tmp.parent.value){
                    tmp = tmp.parent;
                    if(tmp.right == null){
                        node = tmp;
                    }
                }
                node.right = new Node(num);
                node.right.parent = node;
                node = node.right;
            }
            input = br.readLine();
        }
        postOrder(root);
    }

    static void postOrder(Node node){
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        System.out.println(node.value);
    }
}
