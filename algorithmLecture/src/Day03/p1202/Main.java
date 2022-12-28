package Day03.p1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewel implements Comparable<Jewel>{
    int m;
    int v;
    public Jewel(int m, int v){
        this.m = m;
        this.v = v;
    }

    public int getM() {
        return m;
    }

    public int getV() {
        return v;
    }

    @Override
    public int compareTo(Jewel o) {
        return v-o.v;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewel> pq = new PriorityQueue<>(Collections.reverseOrder());
        Jewel[] jewels = new Jewel[n];
        int[] bags = new int[k];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m,v);
        }
        Arrays.sort(jewels, Comparator.comparingInt(Jewel::getM));
        for(int i = 0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bags);

        int index = 0;
        long result = 0;
        for(int i = 0;i<bags.length;i++){
            while(index < n && jewels[index].m <= bags[i]){
                pq.offer(jewels[index++]);
            }
            if(!pq.isEmpty()){
                result += pq.poll().v;
            }
        }
        System.out.println(result);
    }
}
