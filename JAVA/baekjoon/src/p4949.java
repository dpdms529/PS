import java.util.*;
import java.io.*;

public class p4949 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while(!input.equals(".")){
            char arr[] = input.toCharArray();
            Stack<Character> bracket = new Stack<>();
            boolean isBalance = true;
            for(char c : arr){
                switch (c){
                    case '(':
                        bracket.push(')');
                        break;
                    case '[':
                        bracket.push(']');
                        break;
                }
                if(!bracket.isEmpty() && bracket.peek()==c) bracket.pop();
                else if(c==')'|| c==']') {
                    isBalance = false;
                    break;
                }
            }
            if(isBalance && bracket.isEmpty()) System.out.println("yes");
            else System.out.println("no");
            input = br.readLine();
        }
    }
}
