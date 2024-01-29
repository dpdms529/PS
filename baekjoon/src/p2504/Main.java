package p2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] pb = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int value = 1;

        for(int i = 0;i<pb.length;i++) {
            if(pb[i] == '(') {
                value *= 2;
                stack.push('(');
            }
            if(pb[i] == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }else if(pb[i-1] == '(') {
                    result += value;
                }

                stack.pop();
                value /= 2;
            }
            if(pb[i] == '[') {
                value *= 3;
                stack.push('[');
            }
            if(pb[i] == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }else if(pb[i-1] == '[') {
                    result += value;
                }

                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) result = 0;
        System.out.println(result);

    }
}
