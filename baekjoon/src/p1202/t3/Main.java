package p1202.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static Jewel[] jewels;
    static int[] bags;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(getSum());
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new Jewel[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Integer.compare(o1.m, o2.m);
            }
        });

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
    }

    private static long getSum() {
        PriorityQueue<Jewel> pq = new PriorityQueue<>();
        int idx = 0;
        long sum = 0;

        for (int i = 0; i < K; i++) {
            while (idx < N && jewels[idx].m <= bags[i]) {
                pq.offer(jewels[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll().v;
            }
        }
        return sum;
    }
}

class Jewel implements Comparable<Jewel> {
    int m;
    int v;

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Jewel o) {
        return Integer.compare(o.v, v);
    }
}
