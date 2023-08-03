package study.day1.p11003;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Node> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            while(!dq.isEmpty() && dq.getLast().value > numbers[i]) {
                dq.removeLast();
            }

            dq.addLast(new Node(i, numbers[i]));
            if (dq.getFirst().index <= i - L) {
                dq.removeFirst();
            }

            bw.write(dq.getFirst().value + " ");
        }

        bw.flush();

    }
}

class Node {
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
