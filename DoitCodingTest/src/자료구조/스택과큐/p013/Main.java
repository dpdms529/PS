package 자료구조.스택과큐.p013;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 카드2
 * https://www.acmicpc.net/problem/2164
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //카드의 수
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1;i<=N;i++){
            queue.offer(i);
        }

        //카드가 1장 남을 때까지 맨 앞의 숫자 버리고, 그 다음 숫자를 다시 큐에 집어넣는다.
        while(queue.size() > 1){
            queue.poll();
            queue.offer(queue.poll());
        }

        //마지막 숫자 출력
        System.out.println(queue.peek());

    }
}
