import java.util.*;
import java.io.*;

public class p17219 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pwd = st.nextToken();
            map.put(site, pwd);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0;i<m;i++){
            bw.write(map.get(br.readLine()) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
