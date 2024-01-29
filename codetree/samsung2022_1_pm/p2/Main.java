package codetree.samsung2022_1_pm.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, c;
    static Space[][] graph;
    static ArrayList<Space> treeSpaces = new ArrayList<>();

    static final int[] treeDy = {-1, 1, 0, 0};
    static final int[] treeDx = {0, 0, -1, 1};
    static final int[] poisonDy = {-1, -1, 1, 1};
    static final int[] poisonDx = {-1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new Space[n][n];
        treeSpaces = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int tree = Integer.parseInt(st.nextToken());
                graph[i][j] = new Space(i, j, tree);
                System.out.println(graph[i][j].y + " " + graph[i][j].x  + " " + graph[i][j].tree);

                if (graph[i][j].tree > Space.EMPTY) {
                    treeSpaces.add(graph[i][j]);
                }
            }
        }

        for(int i = 0;i<n;i++) {
            for(int j= 0;j<n;j++) {
                System.out.print(graph[i][j].tree + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            run();
        }


    }

    static void run() {
        for (Space space : treeSpaces) {
            growTree(space);
        }

        Map<Position, Integer> newTreeSpaces = new HashMap<>();

        for (Space space : treeSpaces) {
            makeNewTree(space, newTreeSpaces);
        }

        for (Position position : newTreeSpaces.keySet()) {
            graph[position.y][position.x].addTree(newTreeSpaces.get(position));
            treeSpaces.add(graph[position.y][position.x]);
        }

        for(int i = 0;i<n;i++) {
            for(int j= 0;j<n;j++) {
                System.out.print(graph[i][j].tree + " ");
            }
            System.out.println();
        }

    }

    static void growTree(Space space) {
        for (int i = 0; i < 4; i++) {
            int ny = space.y + treeDy[i];
            int nx = space.x + treeDx[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < n && graph[ny][nx].tree > Space.EMPTY) {
                space.addTree(1);
            }
        }

    }

    static void makeNewTree(Space space, Map<Position, Integer> newTreeSpaces) {
        for (int i = 0; i < 4; i++) {
            int ny = space.y + treeDy[i];
            int nx = space.x + treeDx[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < n && !graph[ny][nx].isBlocked && graph[ny][nx].tree == Space.EMPTY) {
                Position position = new Position(ny, nx);
                newTreeSpaces.put(position, newTreeSpaces.getOrDefault(position, 0));
            }
        }

        int newTreeNum = space.tree / newTreeSpaces.size();

        for (Position position : newTreeSpaces.keySet()) {
            newTreeSpaces.put(position, newTreeSpaces.get(position) + newTreeNum);
        }
    }

    static Space findBestSpace() {
        int maxSum = 0;
        Space bestSpace = null;

        for (Space space : treeSpaces) {
            int sum = space.tree;

            for (int i = 0; i < 4; i++) {
                int ny = space.y + poisonDy[i];
                int nx = space.x + poisonDx[i];

                while (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    sum += graph[ny][nx].tree;

                    if (graph[ny][nx].tree <= Space.EMPTY) break;

                    ny += poisonDy[i];
                    nx += poisonDx[i];
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                bestSpace = space;
            }
        }

        return bestSpace;
    }
}

class Space {
    static final int EMPTY = 0;
    static final int WALL = -1;
    int y;
    int x;
    int tree;
    boolean isBlocked;
    int year;

    public Space(int y, int x, int tree) {
        new Space(y, x, tree, false, 0);
        System.out.println(y + " " + x + " " + tree);
    }

    public Space(int y, int x, int tree, boolean isBlocked, int year) {
        this.y = y;
        this.x = x;
        this.tree = tree;
        this.isBlocked = isBlocked;
        this.year = year;
    }

    void addTree(int n) {
        tree += n;
    }

    void block() {
        isBlocked = true;
        year = 0;
        tree = 0;
    }
}

class Position {
    int y;
    int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return y == position.y && x == position.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}