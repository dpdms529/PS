package p1011;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int diff = y - x;
            int sDiff = (int)Math.sqrt(diff);

            if(sDiff * sDiff == diff){
                System.out.println(sDiff*2 - 1);
            }else{
                if(sDiff * sDiff < diff && sDiff * sDiff + sDiff >= diff ){
                    System.out.println(sDiff * 2);
                }else{
                    System.out.println(sDiff * 2 + 1);
                }
            }
        }
    }
}
