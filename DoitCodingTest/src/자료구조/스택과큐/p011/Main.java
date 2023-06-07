package 자료구조.스택과큐.p011;

import java.io.*;
import java.util.Stack;

/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수열 크기
        int n = Integer.parseInt(br.readLine());
        //수열
        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for(int i = 0;i<n;i++){
            //현재 숫자가 i번째 수열 값과 같아질 때까지 스택에 push 하고, 같아지면 pop
            if(arr[i] >= num){
                while(arr[i] >= num){
                    stack.push(num);
                    num++;
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            }else{
                //현재 숫자가 i번째 수열 값보다 크면, 스택의 가장 위의 값과 1번째 수열 값을 비교해서 같으면 pop
                //다르면 수열을 만들 수 없으므로 "NO" 출력
                if(!stack.isEmpty() && stack.peek() == arr[i]){
                    stack.pop();
                    sb.append("-\n");
                }else{
                    sb = new StringBuilder("NO");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
