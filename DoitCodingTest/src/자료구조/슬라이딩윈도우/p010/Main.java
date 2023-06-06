package 자료구조.슬라이딩윈도우.p010;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 최솟값 찾기
 * https://www.acmicpc.net/problem/11003
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //수의 개수
        int N = Integer.parseInt(st.nextToken());
        //최솟값 구하는 범위
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        //L 크기로 한칸씩 이동하면서 최솟값 구하기
        for(int i = 0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());

            //현재 값보다 큰 값들 덱에서 지우기 -> 최소값이 될 수 없으므로
            while(!deque.isEmpty() && deque.getLast().value > a){
                deque.removeLast();
            }

            //현재 값 덱에 추가
            deque.addLast(new Node(i, a));

            //범위 벗어난 값 덱에서 제거
            if(deque.getFirst().index <= i - L){
                deque.removeFirst();
            }

            //덱 첫번째 값이 최소값이므로 출력
            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }
}

class Node {
    int index;
    int value;

    Node(int index, int value){
        this.index = index;
        this.value = value;
    }
}