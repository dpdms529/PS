package p1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        int root = 0;

        if(truthNum != 0) {
            root = Integer.parseInt(st.nextToken());

            for (int i = 1; i < truthNum; i++) {
                int id = Integer.parseInt(st.nextToken());
                union(root, id);
            }
        }

        int[] party = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            party[i] = Integer.parseInt(st.nextToken());

            for (int j = 1; j < partyNum; j++) {
                int id = Integer.parseInt(st.nextToken());

                if(find(id) == root) {
                    union(root, party[i]);
                }else{
                    union(party[i], id);
                }

            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if(find(party[i]) != root) cnt++;
        }

        System.out.println(cnt);
    }

    static void init() {
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        parent[find(b)] = find(a);
    }
}
