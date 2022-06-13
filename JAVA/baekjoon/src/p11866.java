import java.util.*;
import java.io.*;

public class p11866 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            queue.offer(i);
        }
        StringBuilder sb = new StringBuilder("<");
        while(!queue.isEmpty()){
            for(int i = 0;i<k-1;i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        sb.replace(sb.length()-2,sb.length(),">");
        System.out.println(sb);
    }
}
