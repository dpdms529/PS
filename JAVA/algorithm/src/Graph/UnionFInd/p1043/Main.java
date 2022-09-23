package Graph.UnionFInd.p1043;

import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;

    static void union(int a, int b){
        parents[find(a)] = find(b);
    }

    static int find(int a){
        if(a == parents[a]) return a;
        else return parents[a] = find(parents[a]);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i = 0;i<N+1;i++){
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        int[] truths = new int[truthNum];
        for(int i = 0;i<truthNum;i++){
            truths[i] = Integer.parseInt(st.nextToken());
        }

        int[] parties = new int[M];
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int attendNum = Integer.parseInt(st.nextToken());
            int[] attendees = new int[attendNum];
            int partyRoot = -1;
            for(int j = 0;j<attendNum;j++){
                attendees[j] = Integer.parseInt(st.nextToken());
                if(partyRoot == -1) partyRoot = find(attendees[j]);
                else union(attendees[j], partyRoot);
            }
            parties[i] = partyRoot;
        }

        int cnt = M;
        check : for(int i = 0;i<M;i++){
            for(int j = 0;j<truthNum;j++){
                if(find(parties[i]) == find(truths[j])){
                    cnt--;
                    continue check;
                }
            }
        }

        System.out.println(cnt);
    }
}
