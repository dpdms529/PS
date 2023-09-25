package p5639.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] graph = new int[20000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int idx = 1;
        int node = Integer.parseInt(br.readLine());
        graph[idx] = node;

        while((s = br.readLine()) != null) {
            node = Integer.parseInt(s);
            if(node < graph[idx]) {
                idx *= 2;
                graph[idx] = node;
            }else if(node > graph[idx]) {
                int parent = idx / 2;
                while(parent > 0 && node > graph[parent]) {
                    if(graph[parent*2+1] == 0) {
                        idx = parent*2+1;
                    }

                }
            }

        }
    }
}
