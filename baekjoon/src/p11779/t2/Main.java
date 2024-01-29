package p11779.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Node>[] graph;
    static int[] minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        minCost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(minCost, (int)1e9);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c, new ArrayList<>()));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, new ArrayList<>() {{
            add(start);
        }}));
        minCost[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.id == end) {
                System.out.println(cur.cost);
                System.out.println(cur.cities.size());
                for (int city : cur.cities) {
                    System.out.print(city + " ");
                }

                return;
            }

            if (cur.cost <= minCost[cur.id]) {
                for (Node next : graph[cur.id]) {
                    int cost = cur.cost + next.cost;

                    if (cost < minCost[next.id]) {
                        minCost[next.id] = cost;
                        ArrayList<Integer> cities = new ArrayList<>(cur.cities);
                        cities.add(next.id);
                        pq.offer(new Node(next.id, cost, cities));
                    }
                }
            }
        }

    }
}

class Node implements Comparable<Node> {
    int id;
    int cost;
    ArrayList<Integer> cities;

    public Node(int id, int cost, ArrayList<Integer> cities) {
        this.id = id;
        this.cost = cost;
        this.cities = cities;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}
