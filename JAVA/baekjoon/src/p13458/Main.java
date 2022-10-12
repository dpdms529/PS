package p13458;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long sum = 0;
        for(int i = 0;i<N;i++){
            int tmp = A[i] - B < 0 ? 0 : A[i] - B;
            if(tmp == 0) sum += 1;
            else sum += (A[i] - B) % C == 0? (A[i] - B) / C + 1 : (A[i] - B) / C + 2;
        }
        System.out.println(sum);

    }
}
