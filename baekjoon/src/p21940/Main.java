package p21940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = (int) 1e9;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        int[][] cities = initCities();

        int[] friends = getFriends();

        PriorityQueue<Move> result = getResult(cities, friends);

        printXCities(result);
    }

    private static void printXCities(PriorityQueue<Move> result) {
        Move X = result.poll();
        System.out.print(X.city + " ");

        while (!result.isEmpty() && result.peek().cost == X.cost) {
            System.out.print(result.poll().city + " ");
        }
    }

    private static PriorityQueue<Move> getResult(int[][] cities, int[] friends) {
        PriorityQueue<Move> result = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int max = 0;

            for (int j = 0; j < K; j++) {
                max = Math.max(max, cities[friends[j]][i] + cities[i][friends[j]]);
            }

            result.offer(new Move(i, max));
        }
        return result;
    }

    private static int[] getFriends() throws IOException {
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] friends = new int[K];

        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        return friends;
    }

    private static int[][] initCities() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] cities = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(cities[i], INF);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) cities[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            cities[A][B] = C;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    cities[j][k] = Math.min(cities[j][k], cities[j][i] + cities[i][k]);
                }
            }
        }

        return cities;
    }
}

class Move implements Comparable<Move> {
    int city;
    int cost;

    public Move(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public int compareTo(Move o) {
        if (cost == o.cost) return Integer.compare(city, o.city);
        return Integer.compare(cost, o.cost);
    }
}
