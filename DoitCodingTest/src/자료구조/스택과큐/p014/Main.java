package 자료구조.스택과큐.p014;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 절대값 힙
 * https://www.acmicpc.net/problem/11286
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //연산의 개수
        int N = Integer.parseInt(br.readLine());

        //우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            //절대값 비교
            //절대값이 같은 경우에는 음수가 양수보다 작은 수
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if(abs1 == abs2) {
                    return o1 - o2;
                }

                return abs1 - abs2;
            }
        });

        //x가 0이 아니면 우선순위 큐에 입력
        //x가 0이면 우선순위 큐에서 poll() -> 절대값이 가장 작은 수 출력
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x != 0){
                pq.offer(x);
            }else{
                if(pq.isEmpty()){
                    bw.write(String.valueOf(0));
                }else{
                    bw.write(String.valueOf(pq.poll()));
                }

                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
