package p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            parents = new int[N+1];
            init(N);

            int[] d1 = new int[N+1];
            int[] d2 = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                d1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                d2[i] = Integer.parseInt(st.nextToken());
            }

            int day = 0;
            int[] prev = parents;
            boolean flag = true;
            while (flag) {

                for (int i = 1; i <= N; i++) {
                    union(i, d1[i]);
                }
                day++;

                for (int i = 1; i <= N; i++) {
                    if(prev[i] != parents[i]) flag = false;
                }
                if(!flag) continue;

                for (int i = 1; i <= N; i++) {
                    union(i, d2[i]);
                }
                day++;

                for (int i = 1; i <= N; i++) {
                    if(prev[i] != parents[i]) flag = false;
                }
                if(!flag) continue;

            }

            System.out.println("#" + tc + " " + day);

        }

        br.close();
    }

    private static void init(int N) {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int x) {
        if(parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    private static void union(int a, int b) {
        parents[find(b)] = find(a);
    }
}
