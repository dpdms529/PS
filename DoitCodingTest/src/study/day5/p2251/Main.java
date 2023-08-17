package study.day5.p2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Bottle bottleA = new Bottle(A, 0);
        Bottle bottleB = new Bottle(B, 0);
        Bottle bottleC = new Bottle(C, C);
        bottleC.bottles.add(bottleA);
        bottleC.bottles.add(bottleB);

    }

    void bfs(Bottle bottle){
        Queue<Bottle> queue = new LinkedList<>();
        queue.offer(bottle);

        while (!queue.isEmpty()){
            Bottle cur = queue.poll();

            for (Bottle next : cur.bottles) {
                int remain = next.volume - next.water;
                if(remain > 0) {
                }
            }
        }
    }
}

class Bottle {
    int volume;
    int water;

    ArrayList<Bottle> bottles = new ArrayList<>();

    public Bottle(int volume, int water) {
        this.volume = volume;
        this.water = water;
    }
}
