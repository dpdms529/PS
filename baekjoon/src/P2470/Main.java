package P2470;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<N;i++){
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int left = 0;
        int right = N-1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int alkali = 0;
        int acid = 0;

        while(left < right){
            sum = solutions[left] + solutions[right];

            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                alkali = left;
                acid = right;
            }

            if(sum == 0){
                alkali = left;
                acid = right;
                break;
            }else if(sum > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(solutions[alkali] + " " + solutions[acid]);
    }
}
