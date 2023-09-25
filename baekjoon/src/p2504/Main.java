package p2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static final int X = 2;
    static final int Y = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (char c : arr) {
            if(stack.isEmpty()) stack.push(c);
            else {
                if(c == ')') {
                    char top = stack.pop();
                    while(top == '(') {

                    }
                }
            }
        }
    }

    static void calculate() {

    }
}
