import java.util.*;
import java.io.*;

public class p11723 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        for(int i = 1;i<=20;i++){
            all.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<m;i++){
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            int x = 0;
            if(input.length == 2) x = Integer.parseInt(input[1]);
            switch (cmd){
                case "add": set.add(x); break;
                case "remove": set.remove(x); break;
                case "check":
                    if(set.contains(x)) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "toggle":
                    if(set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                case "all": set = all; break;
                case "empty": set = new HashSet<>(); break;
            }
        }
        System.out.println(sb);
    }
}
