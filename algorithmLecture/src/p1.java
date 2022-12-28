import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int len;
    int day;
    Pair(int e1, int e2){
        this.len = e1;
        this.day = e2;
    }

    @Override
    public int compareTo(Pair o) {
        int cmp = this.len - o.len;
        if(cmp==0){
            return o.day - this.day;
        }else{
            return cmp;
        }
    }
}

public class p1 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n;
        int m;
        int d;
        PriorityQueue<Pair> pq;
        int oil;
        long result = 0;
        for(int i = 0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int j = 0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0;k<m;k++){
                    pq.offer(new Pair(Integer.parseInt(st.nextToken()), 0));
                }
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=d;j++){
                oil = Integer.parseInt(st.nextToken());
                long sum = 0;
                for(int k = 0;k<oil;k++){
                    Pair tmp = pq.poll();
                    sum += tmp.len + j - tmp.day - 1;
                    pq.offer(new Pair(1, j));
                }
                result += (j) * sum;
            }
            System.out.println("#" + (i+1) + " " + result);
            result = 0;
        }
    }
}
