import java.util.*;
import java.io.*;

public class p7662 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int k;
        TreeMap<Integer,Integer> map;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<t;i++){
            k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            for(int j = 0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                String c = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if(c.equals("I")){
                    map.put(n, map.getOrDefault(n,0)+1);
                }else{
                    if(map.isEmpty()) continue;
                    if(n == 1){
                        int max = map.lastKey();
                        if(map.get(max)==1) map.remove(max);
                        else map.replace(max, map.get(max)-1);
                    }else{
                        int min = map.firstKey();
                        if(map.get(min)==1) map.remove(min);
                        else map.replace(min, map.get(min)-1);
                    }
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey() + " " + map.firstKey() + "\n");
        }
        System.out.println(sb);
    }
}
