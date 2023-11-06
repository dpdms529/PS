package p4803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int tc = 1;

        while (!(line = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parents = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }

            Set<Integer> trees = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                trees.add(find(parents[i]));
            }

            trees.remove(find(parents[0]));
            switch (trees.size()) {
                case 0:
                    System.out.println("Case " + tc + ": No trees.");
                    break;
                case 1:
                    System.out.println("Case " + tc + ": There is one tree.");
                    break;
                default:
                    System.out.println("Case " + tc + ": A forest of " + trees.size() + " trees.");
            }

            tc++;
        }

    }

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) parents[pa] = 0;
        else parents[Math.max(pa, pb)] = Math.min(pa, pb);
    }

}
