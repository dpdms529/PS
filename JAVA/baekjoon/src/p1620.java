import java.util.*;
import java.io.*;

public class p1620 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for(int i = 1;i<=n;i++){
            String name = br.readLine();
            map.put(String.valueOf(i), name);
            map.put(name, String.valueOf(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<m;i++){
            String quiz = br.readLine();
            String answer = map.get(quiz);
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
