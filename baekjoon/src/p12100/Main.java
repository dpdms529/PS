package p12100;

import java.util.*;
import java.io.*;

class State{
    int value;
    boolean isMerged;
    public State(int value, boolean isMerged){
        this.value = value;
        this.isMerged = isMerged;
    }
}

public class Main {
    static int N;
    static int max = 0;

    static int[][] up(int[][] board){
        int[][] newBoard = new int[N][N];
        for(int i = 0;i<N;i++){
            Deque<State> dq = new ArrayDeque<>();
            for(int j = 0;j<N;j++){
                if(dq.isEmpty()) {
                    if(board[j][i] != 0) dq.addLast(new State(board[j][i], false));
                }else {
                    if(dq.getLast().value==board[j][i] && !dq.getLast().isMerged){
                        State state = dq.removeLast();
                        state.value *= 2;
                        state.isMerged = true;
                        dq.addLast(state);
                    }else if(board[j][i] != 0) {
                        dq.addLast(new State(board[j][i], false));
                    }
                }
            }
            int size = dq.size();
            for(int j = 0;j<size;j++){
                newBoard[j][i] = dq.removeFirst().value;
            }
        }
        return newBoard;
    }

    static int[][] down(int[][] board){
        int[][] newBoard = new int[N][N];
        for(int i = 0;i<N;i++){
            Deque<State> dq = new ArrayDeque<>();
            for(int j = N-1;j>=0;j--){
                if(dq.isEmpty()) {
                    if(board[j][i] != 0) dq.addLast(new State(board[j][i], false));
                }else {
                    if(dq.getLast().value==board[j][i] && !dq.getLast().isMerged){
                        State state = dq.removeLast();
                        state.value *= 2;
                        state.isMerged = true;
                        dq.addLast(state);
                    }else if(board[j][i] != 0) {
                        dq.addLast(new State(board[j][i], false));
                    }
                }
            }
            int size = dq.size();
            for(int j = 0;j<size;j++){
                newBoard[N-1-j][i] = dq.removeFirst().value;
            }
        }
        return newBoard;
    }

    static int[][] left(int[][] board){
        int[][] newBoard = new int[N][N];
        for(int i = 0;i<N;i++){
            Deque<State> dq = new ArrayDeque<>();
            for(int j = 0;j<N;j++){
                if(dq.isEmpty()) {
                    if(board[i][j] != 0) dq.addLast(new State(board[i][j], false));
                }else {
                    if(dq.getLast().value==board[i][j] && !dq.getLast().isMerged){
                        State state = dq.removeLast();
                        state.value *= 2;
                        state.isMerged = true;
                        dq.addLast(state);
                    }else if(board[i][j] != 0) {
                        dq.addLast(new State(board[i][j], false));
                    }
                }
            }
            int size = dq.size();
            for(int j = 0;j<size;j++){
                newBoard[i][j] = dq.removeFirst().value;
            }
        }
        return newBoard;
    }

    static int[][] right(int[][] board){
        int[][] newBoard = new int[N][N];
        for(int i = 0;i<N;i++){
            Deque<State> dq = new ArrayDeque<>();
            for(int j = N-1;j>=0;j--){
                if(dq.isEmpty()) {
                    if(board[i][j] != 0) dq.addLast(new State(board[i][j], false));
                }else {
                    if(dq.getLast().value==board[i][j] && !dq.getLast().isMerged){
                        State state = dq.removeLast();
                        state.value *= 2;
                        state.isMerged = true;
                        dq.addLast(state);
                    }else if(board[i][j] != 0) {
                        dq.addLast(new State(board[i][j], false));
                    }
                }
            }
            int size = dq.size();
            for(int j = 0;j<size;j++){
                newBoard[i][N-1-j] = dq.removeFirst().value;
            }
        }
        return newBoard;
    }

    static void merge(int[][] board, int depth){
        if(depth==5){
            for(int i = 0;i<N;i++){
                for(int j = 0;j<N;j++){
                    if(board[i][j]>max) max = board[i][j];
                }
            }
            return;
        }
        merge(up(board), depth+1);
        merge(down(board), depth+1);
        merge(left(board), depth+1);
        merge(right(board), depth+1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        merge(board, 0);
        System.out.println(max);
    }
}
