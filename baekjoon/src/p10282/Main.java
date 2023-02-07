package p10282;

import java.util.*;
import java.io.*;

public class Main {
    static int n, d, c;
    static ArrayList<Edge>[] computers;
    static int[] virusTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            computers = new ArrayList[n + 1];
            virusTime = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                computers[i] = new ArrayList<>();
            }

            Arrays.fill(virusTime, Integer.MAX_VALUE);

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                computers[b].add(new Edge(a, s));
            }

            dijkstra();

            int num = 0, time = 0;

            for(int i = 1;i<=n;i++){
                if(virusTime[i] != Integer.MAX_VALUE){
                    num++;
                    time = Math.max(time, virusTime[i]);
                }
            }

            System.out.println(num + " " + time);
        }
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(c, 0));
        virusTime[c] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (virusTime[cur.node] >= cur.time) {
                for (Edge next : computers[cur.node]) {
                    if (virusTime[next.node] > cur.time + next.time) {
                        virusTime[next.node] = cur.time + next.time;
                        pq.offer(new Edge(next.node, virusTime[next.node]));
                    }
                }
            }
        }

    }
}

class Edge implements Comparable<Edge> {
    int node;
    int time;

    Edge(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compareTo(Edge o) {
        return time - o.time;
    }
}