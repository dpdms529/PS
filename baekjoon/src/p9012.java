import java.util.*;
import java.io.*;

public class p9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0;i<t;i++){
            char arr[] = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean check = false;
            for(int j = 0;j< arr.length;j++){
                char c = arr[j];
                if(c == '(') stack.push('(');
                else if(!stack.empty() && c == ')') stack.pop();
                else{
                    check = true;
                    break;
                }
            }
            if(check || stack.size()>0) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
