import java.util.*;
import java.io.*;

public class p1107 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[] isBroken = new boolean[10];
        if(m>0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<m;i++){
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int result = Math.abs(n-100);
        for(int i = 0;i<999999;i++){
            String str = String.valueOf(i);
            int len = str.length();
            boolean check = false;
            for(int j = 0;j<len;j++){
                if(isBroken[str.charAt(j)-'0']){
                    check = true;
                    break;
                }
            }
            if(!check){
                int min = Math.abs(n - i) + len;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);

    }
}
