package 탐색.깊이우선탐색.p025;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ABCDE
 * https://www.acmicpc.net/problem/13023
 */
public class Main {
    static int N, M;
    static ArrayList<Integer>[] friends;
    static boolean[] visited;
    static boolean isExist = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0;i<N;i++){
            friends[i] = new ArrayList<>();
        }

        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        for(int i = 0;i<N;i++){
            dfs(i, 1);

            if(isExist) break;
        }

        if(isExist) System.out.println(1);
        else System.out.println(0);

    }

    static void dfs(int num, int d){
        if(d == 5){
            isExist = true;
        }else{
            visited[num] = true;

            for(int next : friends[num]){
                if(!visited[next]){
                    dfs(next, d+1);
                }
            }

            visited[num] = false;
        }
    }
}
