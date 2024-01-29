package codetree.samsung2023_1_am.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Rabbit> rabbits = new ArrayList<>();
    static Map<Integer, Rabbit> rabbitMap = new HashMap<>();
    static int[][] graph;
    static int N, M, P;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());
        for(int q = 0; q < Q; q++) {
            String[] command = br.readLine().split(" ");

            if(command[0].equals("100")) {
                ready(command);
                //test
                System.out.println(rabbits);
                System.out.println(rabbitMap);
            }else if(command[0].equals("200")) {
                int K = Integer.parseInt(command[1]);
                int S = Integer.parseInt(command[2]);

                run(K, S);

            }else if(command[0].equals("300")) {
                int id = Integer.parseInt(command[1]);
                int L = Integer.parseInt(command[2]);
                changeRabbitDistance(id, L);

            }else if(command[0].equals("400")) {
                getBestScore();
            }

        }
    }

    static void ready(String[] command) {
        N = Integer.parseInt(command[1]);
        M = Integer.parseInt(command[2]);
        P = Integer.parseInt(command[3]);

        graph = new int[N+1][M+1];

        for (int i = 4; i < command.length; i+=2) {
            int id = Integer.parseInt(command[i]);
            long distance = Long.parseLong(command[i+1]);
            Rabbit rabbit = new Rabbit(id, distance);
            rabbits.add(rabbit);
            rabbitMap.put(id, rabbit);
        }
    }

    static void run(int K, int S) {
        List<Rabbit> ranRabbits = new ArrayList<>();

        for (int t = 0; t < K; t++) {
            Rabbit rabbit = Collections.min(rabbits);
            ranRabbits.add(rabbit);
            rabbit.addCount();
            PriorityQueue<Position> positions = new PriorityQueue<>();

            for (int i = 0; i < 4; i++) {
                long ny = rabbit.position.y + dy[i] * rabbit.distance;
                long nx = rabbit.position.x + dx[i] * rabbit.distance;
                System.out.println("ny = " + ny + " nx = " + nx);

                if(ny <= 0 || ny > N || nx <= 0 || nx > M) {
                    if(i == 0) ny = (N - 1 + ny) / N % 2 == 0 ? N - (N - 1 + ny) % N : 1 + ny % N;
                    else if(i == 1) ny = ny / N % 2 == 0 ? 1 + ny % N : N - ny % N;
                    else if(i == 2) nx = (M - 1 + nx) / M % 2 == 0 ? M - (M - 1 + nx) % M : 1 + nx % M;
                    else if(i == 3) nx = nx / M % 2 == 0 ? 1 + nx % M : M - nx % M;
                }

                System.out.println("ny = " + ny + " nx = " + nx);

                positions.offer(new Position((int)ny, (int)nx));
            }

            Position position = positions.poll();
            rabbit.move(position);
            //test
            System.out.println(rabbit);

            for (Rabbit r : rabbits) {
                if(!r.equals(rabbit)) {
                    r.addScore(position.sum);
                }
            }

            //test
//            System.out.println(rabbits);
//            System.out.println();
        }

        Rabbit bestRabbit = Collections.max(ranRabbits, new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                if(o1.position.sum == o2.position.sum) {
                    if(o1.position.y == o2.position.y) {
                        if(o1.position.x == o2.position.x) {
                            return Integer.compare(o2.id, o1.id);
                        }
                        return Integer.compare(o1.position.x, o2.position.x);
                    }
                    return Integer.compare(o1.position.y, o2.position.y);
                }
                return Integer.compare(o1.position.sum, o2.position.sum);
            }
        });

        bestRabbit.addScore(S);

        //test
        System.out.println(rabbits);
    }

    static void changeRabbitDistance(int id, int L) {
        Rabbit rabbit = rabbitMap.get(id);
        rabbit.changeDistance(L);
        System.out.println(rabbits);
    }

    static void getBestScore() {
        Rabbit rabbit = Collections.max(rabbits, new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                if (o1.position.equals(o2.position)) {
                    return Long.compare(o1.totalScore, o2.totalScore);
                } else return o1.position.compareTo(o2.position);
            }
        });

        System.out.println(rabbit.totalScore);
    }
}

class Rabbit implements Comparable<Rabbit> {
    Integer id;
    Long distance;
    Integer count = 0;
    Long totalScore = 0L;
    Position position = new Position(1, 1);

    public Rabbit(Integer id, Long distance) {
        this.id = id;
        this.distance = distance;
    }

    public void move(Position position) {
        this.position = position;
    }

    public void changeDistance(long L) {
        distance *= L;
    }

    public void addScore(long score) {
        totalScore += score;
    }

    public void addCount() {
        count++;
    }

    @Override
    public int compareTo(Rabbit o) {
        if(count == o.count) {
            if(position.sum == o.position.sum) {
                if(position.y == o.position.y) {
                    if(position.x == o.position.x) {
                        return Integer.compare(id, o.id);
                    }
                    return Integer.compare(position.x, o.position.x);
                }
                return Integer.compare(position.y, o.position.y);
            }
            return Integer.compare(position.sum, o.position.sum);
        }
        return Integer.compare(count, o.count);
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "id=" + id +
                ", distance=" + distance +
                ", count=" + count +
                ", totalScore=" + totalScore +
                ", position=" + position +
                '}';
    }
}

class Position implements Comparable<Position> {
    Integer y;
    Integer x;
    Integer sum;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
        sum = y + x;
    }

    @Override
    public int compareTo(Position o) {
        if(sum == o.sum) {
            if(y == o.y) {
                return Integer.compare(o.x, x);
            }
            return Integer.compare(o.y, y);
        }
        return Integer.compare(o.sum, sum);
    }

    @Override
    public String toString() {
        return "Position{" +
                "y=" + y +
                ", x=" + x +
                ", sum=" + sum +
                '}';
    }
}