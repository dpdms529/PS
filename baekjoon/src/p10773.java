import java.util.*;
import java.io.*;

public class p10773 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        for(int i = 0;i<k;i++){
            n = Integer.parseInt(br.readLine());
            if(n!=0) stack.push(n);
            else stack.pop();
        }
        int sum = 0;
        for(int i : stack){
            sum += i;
        }
        System.out.println(sum);
    }
}
