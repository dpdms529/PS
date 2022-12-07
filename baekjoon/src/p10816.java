import java.util.*;
import java.io.*;

public class p10816 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[20000001];
        while(st.hasMoreTokens()){
            int index = 10000000 + Integer.parseInt(st.nextToken());
            arr[index]++;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<m;i++){
            int index = 10000000 + Integer.parseInt(st.nextToken());
            sb.append(arr[index] + " ");
        }
        System.out.println(sb);

    }
}
