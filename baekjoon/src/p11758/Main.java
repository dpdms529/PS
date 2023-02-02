package p11758;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] points = new int[3][2];

        for(int i = 0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        int ccw = (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) - (points[2][0]- points[0][0]) * (points[1][1] - points[0][1]);

        if(ccw > 0){
            System.out.println(1);
        }else if(ccw < 0){
            System.out.println(-1);
        }else{
            System.out.println(0);
        }

    }
}
