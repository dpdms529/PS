package 자료구조.스택과큐.p012;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오큰수
 * https://www.acmicpc.net/problem/17298
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 크기
        int N = Integer.parseInt(br.readLine());

        //수열
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //오큰수 : A_i보다 오른쪽에 있으면서 A_i보다 큰 수 중 가장 왼쪽에 있는 수
        int[] NGE = new int[N];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                NGE[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            NGE[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            bw.write(NGE[i] + " ");
        }

        bw.flush();
        bw.close();
    }

}
