package p1987;

import java.util.*;
import java.io.*;

public class Main {
    static int R, C, maxMove;
    static String[] board;
    static Set<Character> alphabet = new HashSet<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R];

        for(int i = 0;i<R;i++){
            board[i] = br.readLine();
        }

        alphabet.add(board[0].charAt(0));

        dfs(new Position(0,0,1));

        System.out.println(maxMove);

    }

    static void dfs(Position pos){
        maxMove = Math.max(maxMove, pos.move);

        for(int i = 0;i<4;i++){
            int ny = pos.y + dy[i];
            int nx = pos.x + dx[i];

            if(ny>=0 && ny<R && nx>=0 && nx<C && !alphabet.contains(board[ny].charAt(nx))){
                alphabet.add(board[ny].charAt(nx));
                dfs(new Position(ny, nx, pos.move + 1));
                alphabet.remove(board[ny].charAt(nx));
            }
        }

    }
}

class Position{
    int y;
    int x;
    int move;

    Position(int y, int x, int move){
        this.y = y;
        this.x = x;
        this.move = move;
    }
}
