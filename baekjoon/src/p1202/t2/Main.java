package p1202.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //보석 개수 N, 가방 개수 K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        int[] bags = new int[K];

        //보석 무게 M, 가격 V 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(M, V);
        }

        //낮은 무게 순으로 보석 정렬
        Arrays.sort(jewels);

        //가방에 담을 수 있는 최대 무게 C 입력
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bags[i] = C;
        }

        //담을 수 있는 무게가 적은 순으로 가방 정렬
        Arrays.sort(bags);

        //보석을 높은 가격 순으로 정렬
        Comparator<Jewel> jewelComparator = Comparator.comparingInt(Jewel::getV).reversed();

        PriorityQueue<Jewel> pq = new PriorityQueue<>(jewelComparator);

        //가방에 담을 수 있는 보석들을 모두 pq에 넣어본 후 가장 가격이 높은 보석 꺼내서 result에 가격 더해주기
        //보석과 가방 모두 무게가 적은 순으로 정렬해놓았기 때문에
        //다음 가방에 넣을 보석을 고를 때 이미 pq에 넣어져있던 보석도 가방에 넣을 수 있는 보석 후보임
        int index = 0;
        long result = 0;
        for (int i = 0; i < K; i++) {
            while (index < N && jewels[index].m <= bags[i]) {
                pq.offer(jewels[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll().v;
            }
        }

        System.out.println(result);

    }
}

class Jewel implements Comparable<Jewel> {
    int m;
    int v;

    public int getM() {
        return m;
    }

    public int getV() {
        return v;
    }

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Jewel o) {
        return Integer.compare(m, o.m);
    }
}
