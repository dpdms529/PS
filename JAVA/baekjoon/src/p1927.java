import java.util.*;
import java.io.*;

public class p1927 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(heap.isEmpty()) System.out.println(0);
                else System.out.println(heap.poll());
            }else{
                heap.offer(x);
            }

        }

    }
}
