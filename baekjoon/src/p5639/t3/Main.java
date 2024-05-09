package p5639.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.parseInt(br.readLine());
        Node root = new Node(value);
        Node cur = root;

        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            value = Integer.parseInt(line);
            Node node = new Node(value);

            if (value < cur.getValue()) {
                node.setParent(cur);
                cur.setLeft(node);
                cur = node;
            } else if (value > cur.getValue()) {
                Node tmp = cur;
                while (tmp != root && value > tmp.getParent().getValue()) {
                    tmp = tmp.getParent();

                    if(tmp.getRight() == null) {
                        cur = tmp;
                    }
                }

                node.setParent(cur);
                cur.setRight(node);
                cur = node;
            }
        }

        postOrder(root);

    }

    static void postOrder(Node node) {
        if(node.getLeft() != null) {
            postOrder(node.getLeft());
        }

        if(node.getRight() != null) {
            postOrder(node.getRight());
        }

        System.out.println(node.getValue());
    }
}

class Node {
    private int value;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

