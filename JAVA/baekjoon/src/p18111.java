import java.util.*;
import java.io.*;

public class p18111 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int area[][] = new int[n][m];
        int blockNum = 0;
        int h = 256;
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                blockNum += area[i][j];
                if(area[i][j] < h) h = area[i][j];
            }
        }
        blockNum += b;
        int time[] = new int[257];
        for(int i = 0;i<257;i++){
            time[i] = Integer.MAX_VALUE;
        }
        while(h<257){
            if(blockNum < h * n * m) break;
            time[h] = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(area[i][j]>h) time[h] += 2 * (area[i][j] - h);
                    else if(area[i][j]<h) time[h] += (h - area[i][j]);
                }
            }
            h++;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<257;i++){
            if(time[i]<min) min = time[i];
        }
        ArrayList<Integer> hlist = new ArrayList<>();
        for(int i = 0;i<257;i++){
            if(time[i]==min) hlist.add(i);
        }
        System.out.println(min + " " + hlist.get(hlist.size()-1));

    }
}
