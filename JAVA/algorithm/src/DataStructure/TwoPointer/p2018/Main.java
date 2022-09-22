package DataStructure.TwoPointer.p2018;

import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;
        while(end != N){
            int tmp = 0;
            if(sum == N) count++;
            if(sum >= N) tmp -= start++;
            if(sum <= N) tmp += ++end;
            sum += tmp;
        }
        System.out.println(count);
    }
}
