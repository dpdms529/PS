import java.util.*;
import java.io.*;

public class p5430 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        char[] cmd;
        int cmdNum = 0;
        int n;
        String arrStr;
        String[] arr;
        Deque<Integer> deque;
        boolean reverse;
        StringBuilder sb = new StringBuilder();
        check:for(int i = 0;i<t;i++){
            cmd = br.readLine().toCharArray();
            cmdNum = cmd.length;
            n = Integer.parseInt(br.readLine());
            arrStr = br.readLine();
            deque = new ArrayDeque<>();
            reverse = false;
            if(n==0){
                arr = new String[0];
            }else arr = arrStr.substring(1,arrStr.length()-1).split(",");
            for(int j = 0;j<n;j++){
                deque.offer(Integer.parseInt(arr[j]));
            }
            int rNum = 0;
            for(int j = 0;j<cmdNum;j++){
                if(cmd[j] == 'D'){
                    if(deque.isEmpty()){
                        sb.append("error\n");
                        continue check;
                    }else{
                        if(reverse) deque.pollLast();
                        else deque.poll();
                    }
                }else{
                    if(reverse) reverse = false;
                    else reverse = true;
                }
            }
            if(deque.isEmpty()){
                sb.append("[]\n");
            }else{
                sb.append("[");
                while(!deque.isEmpty()){
                    if(reverse) sb.append(deque.pollLast()+",");
                    else sb.append(deque.poll()+",");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append("]\n");
            }
        }
        System.out.println(sb);

    }
}
