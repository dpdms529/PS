import java.util.*;
import java.io.*;

public class p9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                map.putIfAbsent(category, new ArrayList<>());
                map.get(category).add(item);
            }
            int size = map.size();
            ArrayList<String> keys = new ArrayList<>(map.keySet());
            int cnt = 1;
            for(int j = 0;j<size;j++){
                cnt *= map.get(keys.get(j)).size() + 1;
            }
            System.out.println(cnt-1);
        }
    }
}
