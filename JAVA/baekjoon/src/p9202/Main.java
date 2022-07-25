package Day04.p9202;

import java.util.*;
import java.io.*;

class Node{
    boolean isWord = false;
    boolean isHit = false;
    Node[] child = new Node[26];

    void clearHit(){
        isHit = false;
        for(int i = 0;i<child.length;i++){
            if(child[i] != null){
                child[i].clearHit();
            }
        }
    }

    boolean hasChild(char c){
        return child[c - 'A'] != null;
    }

    Node getChild(char c){
        return child[c - 'A'];
    }
}

public class Main {
    static int w,b;
    static Node root = new Node();
    static char[][] board = new char[4][4];
    static boolean[][] visited = new boolean[4][4];
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static StringBuilder sb = new StringBuilder();
    static int sum = 0;
    static int count = 0;

    static void insertNode(String word){
        Node current = root;
        for(int i = 0;i<word.length();i++){
            char a = word.charAt(i);
            int index = a - 'A';
            if(current.child[index]==null){
                current.child[index] = new Node();
            }
            current = current.child[index];
        }
        current.isWord = true;
    }

    static void search(int y, int x, Node node){
        visited[y][x] = true;
        sb.append(board[y][x]);
        if(node.isWord && !node.isHit){
            node.isHit = true;
            String foundWord = sb.toString();
            int length = foundWord.length();
        }
        for(int i = 0;i<8;i++){
            int ny = y = dy[i];
            int nx = x + dx[i];
            if(ny>=0 && ny<4 && nx>=0 && nx<4){
                if(!visited[ny][nx] && node.hasChild(board[ny][nx])){
                    search(ny, nx, node.getChild(board[ny][nx]));
                }
            }
        }
        visited[y][x] = false;
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        w = Integer.parseInt(br.readLine());
        for(int i = 0;i<w;i++){
            insertNode(br.readLine());
        }
        br.readLine();
        b = Integer.parseInt(br.readLine());
        for(int i = 0;i<b;i++){
            for(int j = 0;j<4;j++){
            }

        }


    }

}
