package p5052.t2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            List<String> numbers = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String number = br.readLine();
                numbers.add(number);
                trie.insert(number);
            }

            boolean flag = true;

            for (String number : numbers) {
                if(trie.contains(number)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                bw.write("YES\n");
            }else {
                bw.write("NO\n");;
            }

        }

        bw.flush();
        bw.close();
    }
}

class Trie {
    Node root = new Node();

    public void insert(String number) {
        Node node = root;

        for (int i = 0; i < number.length(); i++) {
            node = node.children.computeIfAbsent(number.charAt(i), character -> new Node());
        }

        node.isLastChar = true;
    }

    public boolean contains(String number) {
        Node node = root;

        for (int i = 0; i < number.length(); i++) {
            node = node.children.get(number.charAt(i));

            if(node == null) {
                return false;
            }
        }

        if(node.isLastChar) {
            if(node.children.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isLastChar;
}
