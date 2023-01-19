package p1918;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expr = br.readLine();

        Map<Character, Integer> priority = Map.of('(', 1, '+', 2, '-', 2, '*', 3, '/', 3, ')', 4);


        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<expr.length();i++){
            char c = expr.charAt(i);

            if(c >= 'A' && c <= 'Z'){
                sb.append(c);
            }else{
                while(c != '(' && !stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)){
                    if(stack.peek() == ')'){
                        stack.pop();

                        while(stack.peek() != '('){
                            sb.append(stack.pop());
                        }

                        stack.pop();
                    }else{
                        sb.append(stack.pop());
                    }
                }

                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek() == ')'){
                stack.pop();

                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }

                stack.pop();
            }else{
                sb.append(stack.pop());
            }
        }

        System.out.println(sb);
    }
}
