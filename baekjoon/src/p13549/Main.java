package p13549;

import java.util.*;
import java.io.*;

public class Main {
    static final int END_POSITION = 100000;

    static BufferedReader br;
    static int N, K;
    static int[] totalSec;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        init();

        dijkstra();

        System.out.println(totalSec[K]);

        br.close();
    }

    public static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        totalSec = new int[END_POSITION + 1];
        Arrays.fill(totalSec, END_POSITION);
    }

    public static void dijkstra(){
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(N, 0));
        totalSec[N] = 0;

        while(!pq.isEmpty()){
            Position cur = pq.poll();

            if(totalSec[cur.pos] >= cur.sec){
                for(MoveType moveType : MoveType.values()){
                    Position next = move(cur, moveType);

                    if(next.pos>=0 && next.pos<=END_POSITION && totalSec[next.pos] > next.sec){
                        totalSec[next.pos] = next.sec;
                        pq.offer(new Position(next.pos, next.sec));
                    }
                }
            }
        }
    }

    public static Position move(Position position, MoveType moveType){
        if(moveType == MoveType.TELEPORTATION){
            return new Position(position.pos * moveType.dist, position.sec + moveType.sec);
        }else{
            return new Position(position.pos + moveType.dist, position.sec + moveType.sec);
        }
    }
}

class Position implements Comparable<Position>{
    int pos;
    int sec;

    public Position(int pos, int sec){
        this.pos = pos;
        this.sec = sec;
    }

    @Override
    public int compareTo(Position o) {
        return sec - o.sec;
    }
}

enum MoveType{
    WALK_FORWARD(1, 1),
    WALK_BACKWARD(-1, 1),
    TELEPORTATION(2, 0);

    final int dist, sec;

    MoveType(int dist, int sec){
        this.dist = dist;
        this.sec = sec;
    }
}
