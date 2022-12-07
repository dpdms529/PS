import java.util.*;
import java.io.*;

public class p1874 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        Stack<Integer> stack1 = new Stack<>();
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            stack1.push(n-i);
        }
        Stack<Integer> stack2 = new Stack<>();
        ArrayList<Character> action = new ArrayList<>();
        int i = 0;
        int target = arr[i];
        boolean flag = false;
        while(i<n){
            while(!stack1.isEmpty() && target != stack1.peek()){
                stack2.push(stack1.pop());
                action.add('+');
            }
            if(stack1.isEmpty()){
                flag = true;
                break;
            }
            stack2.push(stack1.pop());
            action.add('+');
            while(!stack2.isEmpty() && target == stack2.peek()) {
                stack2.pop();
                action.add('-');
                i++;
                if(i<n){
                    target = arr[i];
                }else break;
            }
        }
        if(flag) System.out.println("NO");
        else{
            for(char c : action){
                System.out.println(c);
            }
        }
    }
}
