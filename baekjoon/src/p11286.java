import java.util.*;
import java.io.*;

public class p11286 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff = Math.abs(o1) - Math.abs(o2);
                if(diff==0) return o1 - o2;
                return diff;
            }
        });
        for(int i = 0;i<n;i++){
            x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }else{
                pq.offer(x);
            }
        }

    }
}
