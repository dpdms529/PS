package p11054;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static int N;
    static int[] sequence;
    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        initSequence();

        System.out.println(getResult(getIncreaseSequence(), getDecreaseSequence()));

        br.close();
    }

    public static void initSequence() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<N;i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static int[] getIncreaseSequence(){
        int[] increase = new int[N];

        for(int i = 0;i<N;i++){
            for(int j = 0;j<i;j++){
                if(sequence[i] > sequence[j]){
                    increase[i] = Math.max(increase[i], increase[j]);
                }
            }
            increase[i]++;
        }

        return increase;
    }

    public static int[] getDecreaseSequence(){
        int[] decrease = new int[N];

        for(int i = N-1;i>=0;i--){
            for(int j = N-1;j>i;j--){
                if(sequence[i] > sequence[j]){
                    decrease[i] = Math.max(decrease[i], decrease[j]);
                }
            }
            decrease[i]++;
        }

        return decrease;
    }

    public static int getResult(int[] increase, int[] decrease){
        int result = 0;

        for(int i = 0;i<N;i++){
            result = Math.max(result, increase[i] + decrease[i]);
        }

        return result - 1;
    }
}
