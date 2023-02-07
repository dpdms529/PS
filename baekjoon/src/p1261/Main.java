package p1261;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] miro;
    static int[][] brokenWall;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        brokenWall = new int[N][M];

        for(int i = 0;i<N;i++){
            String s = br.readLine();

            for(int j = 0;j<M;j++){
                miro[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0;i<N;i++){
            Arrays.fill(brokenWall[i], Integer.MAX_VALUE);
        }

        dijkstra();

        System.out.println(brokenWall[N-1][M-1]);
    }

    static void dijkstra(){
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(0,0,0));
        brokenWall[0][0] = 0;

        while(!pq.isEmpty()){
            Position cur = pq.poll();

            if(brokenWall[cur.y][cur.x] >= cur.brokenWallNum){
                for(int i = 0;i<4;i++){
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    int nextBrokenWallNum = cur.brokenWallNum;

                    if(ny>=0 && ny<N && nx>=0 && nx<M){
                        if(miro[ny][nx] == 1){
                            nextBrokenWallNum++;
                        }

                        if(brokenWall[ny][nx] > nextBrokenWallNum){
                            brokenWall[ny][nx] = nextBrokenWallNum;
                            pq.offer(new Position(ny, nx, nextBrokenWallNum));
                        }
                    }
                }
            }
        }
    }
}

class Position implements Comparable<Position>{
    int y;
    int x;
    int brokenWallNum;

    public Position(int y, int x, int brokenWallNum){
        this.y = y;
        this.x = x;
        this.brokenWallNum = brokenWallNum;
    }

    @Override
    public int compareTo(Position o) {
        return brokenWallNum - o.brokenWallNum;
    }
}
