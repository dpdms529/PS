package 자료구조.구간합.p004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //표의 크기
        int N = Integer.parseInt(st.nextToken());

        //합을 구해야 하는 횟수
        int M = Integer.parseInt(st.nextToken());

        //수 배열
        int[][] numbers = new int[N+1][N+1];

        //합 배열
        int[][] sums = new int[N+1][N+1];

        //배열 값 채우기
        for(int i = 1;i<=N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1;j<=N;j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + numbers[i][j];
            }
        }

        //구간 합 구하기ㅔ
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1]);
        }

    }
}
