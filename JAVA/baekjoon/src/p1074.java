import java.util.*;
import java.io.*;

public class p1074 {
    public static int r,c;
    public static int size;
    public static int cnt = 0;

    public static void z(int y, int x, int range){
        if(range==1){
            if(y==r && x==c){
                System.out.println(cnt);
                return;
            }
        }else{
            range = range / 2;
            if(r<y+range){
                if(c<x+range){
                    z(y,x,range);
                }else{
                    cnt = cnt + range * range;
                    z(y,x+range,range);
                }
            }else{
                if(c<x+range){
                    cnt = cnt + range * range * 2;
                    z(y+range,x,range);
                }else{
                    cnt = cnt + range * range * 3;
                    z(y+range,x+range,range);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        size = (int)Math.pow(2,n);
        z(0,0,size);
    }
}
