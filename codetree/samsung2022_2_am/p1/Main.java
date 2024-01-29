package codetree.samsung2022_2_am.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static Space[][] graph;
    static ArrayList<Player> players = new ArrayList<Player>();

    static final int EMPTY = 0;
    //상 우 하 좌
    static final int U = 0;
    static final int R = 1;
    static final int D = 2;
    static final int L = 3;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        for(int i = 0;i<k;i++) {
            play();
        }

    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   //격자 크기
        m = Integer.parseInt(st.nextToken());   //플레이어 수
        k = Integer.parseInt(st.nextToken());   //라운드 수

        //격자 생성
        graph = new Space[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                graph[i][j] = new Space(Integer.parseInt(st.nextToken()));
            }
        }

        //플레이어 생성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            Player player = new Player(new Position(y, x), d, s);
            players.add(player);
            graph[y][x].setPlayer(player);
        }
    }

    static void play() {
        for(Player player : players) {
            player.move();

            Space space = graph[player.position.y][player.position.x];

            if(space.hasPlayer()) {
                player.fight(space.player);
            }else space.setPlayer(player);
        }

        ArrayList<Integer> points = new ArrayList<>();
        for(Player player : players) {
            points.add(player.point);
        }

        System.out.println(points);

    }


}

class Space {
    Player player;
    PriorityQueue<Integer> guns = new PriorityQueue<>(Collections.reverseOrder());

    public Space(int gun) {
        addGun(gun);
    }

    void setPlayer(Player player) {
        this.player = player;
    }

    void addGun(int gun) {
        guns.offer(gun);
    }

    boolean hasPlayer() {
        if(player != null) return true;
        return false;
    }

    int getStrongestGun() {
        return guns.peek();
    }

    int pollStrongestGun() {
        return guns.poll();
    }
}

class Player implements Comparable<Player>{
    Position position;
    int direction;
    int strength;
    int gun = 0;
    int point = 0;

    public Player(Position position, int direction, int strength) {
        this.position = position;
        this.direction = direction;
        this.strength = strength;
    }

    int getPower() {
        return strength + gun;
    }

    void addPoint(int point) {
        this.point += point;
    }

    void move() {
        int ny = position.y + Main.dy[direction];
        int nx = position.x + Main.dx[direction];

        if(ny <= 0) {
            direction = Main.D;
            ny = position.y + Main.dy[direction];
        }else if(ny > Main.n) {
            direction = Main.U;
            ny = position.y + Main.dy[direction];
        }else if(nx <= 0) {
            direction = Main.R;
            nx = position.x + Main.dx[direction];
        }else if(nx > Main.n) {
            direction = Main.L;
            nx = position.x + Main.dx[direction];
        }

        position.move(ny, nx);
    }

    void fight(Player player) {

        if(compareTo(player) > 0) {
            addPoint(getPower() - player.getPower());
            player.lose();
            win();
        }else {
            addPoint(player.getPower() - getPower());
            lose();
            player.win();
        }

    }

    void lose() {
        Main.graph[position.y][position.x].addGun(this.gun);
        this.gun = 0;

        int ny = position.y + Main.dy[direction];
        int nx = position.x + Main.dx[direction];

        if(ny <= 0 || ny > Main.n || nx <= 0 || nx > Main.n || !Main.graph[ny][nx].hasPlayer()) {
            direction = direction == Main.L ? Main.U : direction + 1;
            ny = position.y + Main.dy[direction];
            nx = position.x + Main.dx[direction];
        }

        position.move(ny, nx);
        Main.graph[ny][nx].setPlayer(this);
        gun = Main.graph[ny][nx].pollStrongestGun();
    }

    void win() {
        selectGun();
        Main.graph[position.y][position.x].setPlayer(this);
    }


    void selectGun() {
        Space space = Main.graph[position.y][position.x];
        if(space.getStrongestGun() > gun) {
            space.addGun(gun);
            gun = space.pollStrongestGun();
        }
    }

    @Override
    public int compareTo(Player o) {
        if(getPower() == o.getPower()) return Integer.compare(strength, o.strength);
        return Integer.compare(getPower(), o.getPower());
    }
}

class Position {
    int y;
    int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    boolean isSame(Position position) {
        if (y == position.y && x == position.x) return true;
        return false;
    }

    void move(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
