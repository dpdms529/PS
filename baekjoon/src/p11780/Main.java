package p11780;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i!=j) graph[i][j] = INF;
            }
        }

        ArrayList<Integer>[][] paths = new ArrayList[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
               paths[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);

            if(paths[a][b].size() == 0) {
                paths[a][b].add(a);
                paths[a][b].add(b);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    int cost = graph[j][i] + graph[i][k];

                    if(cost < graph[j][k]) {
                        graph[j][k] = cost;
                        paths[j][k].clear();
                        paths[j][k].addAll(paths[j][i]);
                        paths[j][k].remove(paths[j][k].size()-1);
                        paths[j][k].addAll(paths[i][k]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) graph[i][j] = 0;

                bw.write(graph[i][j] + " ");
            }
            bw.newLine();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(paths[i][j].size() + " ");

                for(int city : paths[i][j]) {
                    bw.write(city + " ");
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
