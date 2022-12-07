package p1722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] fact;
    static boolean[] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        fact = new long[N];
        fact[0]  = 1;
        for(int i = 1;i<N;i++){
            fact[i] = fact[i-1] * i;
        }
        visited = new boolean[N+1];
        if(K == 1){
            long target = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<N;i++){
                for(int j = 1;j<=N;j++){
                    if(visited[j]) continue;
                    if(target > fact[N-i-1]){
                        target -= fact[N-i-1];
                    }else{
                        sb.append(j + " ");
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(sb);
        }else if(K == 2){
            int[] nums = new int[N];
            for(int i = 0;i<N;i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            long result = 0;

            for(int i = 0;i<N;i++){
                for(int j = 1;j<nums[i];j++){
                    if(!visited[j]){
                        result += fact[N-i-1];
                    }
                }
                visited[nums[i]] = true;
            }

            System.out.println(result+1);
        }
    }
}
