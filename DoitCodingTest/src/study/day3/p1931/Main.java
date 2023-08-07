package study.day3.p1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Time[] times = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            times[i] = new Time(start, end);
        }

        Arrays.sort(times);

        ArrayList<Time> reservation = new ArrayList<>();

        reservation.add(times[0]);

        for (int i = 1; i < N; i++) {
            if (times[i].start >= reservation.get(reservation.size() - 1).end) {
                reservation.add(times[i]);
            }
        }

        System.out.println(reservation.size());

    }
}

class Time implements Comparable<Time> {
    int start;
    int end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (o.end == end) {
            return start - o.start;
        } else {
            return end - o.end;
        }
    }
}
