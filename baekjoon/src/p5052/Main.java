package p5052;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];

            for(int i = 0;i<n;i++){
                numbers[i] = br.readLine();
            }

            Arrays.sort(numbers);

            boolean find = false;

            for(int i = 0;i<n-1;i++){
                if(numbers[i+1].startsWith(numbers[i])){
                    find = true;
                    break;
                }
            }

            if(find){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
