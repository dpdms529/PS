package codetree.samsung2022_2_pm.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[][] isBlocked;
    static Position[] storeToGo;
    static ArrayList<Position> basecamps = new ArrayList<>();
    static Queue<Position> queue = new LinkedList<>();

    static int[][] distances;
    static final int EMPTY = 0;
    static final int BASECAMP = 1;
    static final int STORE = 2;
    static final int[] dy = {-1, 0, 0, 1};
    static final int[] dx = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        isBlocked = new boolean[n+1][n+1];
        storeToGo = new Position[m+1];

        for(int i = 1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=n;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if(graph[i][j] == BASECAMP) basecamps.add(new Position(i, j));
            }
        }

        for(int i = 1;i<=m;i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            graph[y][x] = STORE;
            storeToGo[i] = new Position(y, x);
        }

        for(int i = 1;i<=m;i++) {
            selectBasecamp(i);
            for(Position basecamp : basecamps) {
                System.out.println(isBlocked[basecamp.y][basecamp.x]);
            }
            System.out.println();
        }

    }

    static void move() {
        selectBasecamp(0);

        while(!queue.isEmpty()) {

        }
    }

    static void selectBasecamp(int idx) {
        PriorityQueue<Edge> pq = new PriorityQueue();
        distances = new int[n+1][n+1];
        for(int i = 0;i<=n;i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        Position store = storeToGo[idx];
        pq.offer(new Edge(store, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(cur.distance <= distances[cur.to.y][cur.to.x]) {
                for(int i = 0;i<4;i++) {
                    int ny = cur.to.y + dy[i];
                    int nx = cur.to.x + dx[i];

                    if(ny > 0 && ny <= n && nx > 0 && nx <= n && !isBlocked[ny][nx]) {
                        int distance = cur.distance + 1;
                        if(distance < distances[ny][nx]) {
                            pq.offer(new Edge(new Position(ny, nx), distance));
                        }
                    }
                }
            }
        }

        for(Position basecamp : basecamps) {
        }
    }

//    static void findShortestPath(int y, int x) {
//
//    }
}

class Position implements Comparable<Position>{
    int y;
    int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Position o) {
        if(y == o.y) return Integer.compare(x, o.x);
        return Integer.compare(y, o.y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}

class Edge implements Comparable<Edge>{
    Position to;
    int distance;

    public Edge(Position to, int distance) {
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(distance, o.distance);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "to=" + to +
                ", distance=" + distance +
                '}';
    }
}