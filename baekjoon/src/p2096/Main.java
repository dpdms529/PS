package p2096;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args)throws IOException {
        init();


    }

    public static void init()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][3];
        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
