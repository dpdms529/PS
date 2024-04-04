package p7432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node node = new Node();

        for (int i = 0; i < N; i++) {
            String dir = br.readLine();
            node.insert(dir);
        }

        node.print(node, 0);

    }
}

class Node {

    Map<String, Node> children = new TreeMap<>();

    void insert(String directory) {
        Node node = this;
        String[] split = directory.split("\\\\");
        for (String s : split) {
            node.children.putIfAbsent(s, new Node());
            node = node.children.get(s);
        }
    }

    void print(Node cur, int depth) {
        Node node = cur;
        if (node.children != null) {
            for (String key : node.children.keySet()) {
                for (int i = 0; i < depth; i++) {
                    System.out.print(" ");
                }
                System.out.println(key);
                print(node.children.get(key), depth + 1);
            }
        }
    }
}
