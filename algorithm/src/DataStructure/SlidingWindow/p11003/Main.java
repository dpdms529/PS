package DataStructure.SlidingWindow.p11003;

import java.util.*;
import java.io.*;

class Node{
    int index;
    int value;
    public Node(int index, int value){
        this.index = index;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            int current = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.getLast().value > current){
                deque.removeLast();
            }
            deque.addLast(new Node(i, current));
            if(deque.getFirst().index <= i - L){
                deque.removeFirst();
            }
            sb.append(deque.getFirst().value + " ");
        }
        System.out.println(sb);
    }
}
