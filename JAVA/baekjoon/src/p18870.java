import java.util.*;
import java.io.*;

public class p18870 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int item = Integer.parseInt(st.nextToken());
            list.add(item);
            map.put(item, 0);
        }
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        for(int i = 1;i<sortedList.size();i++){
            if(sortedList.get(i) - sortedList.get(i-1) == 0) map.replace(sortedList.get(i), map.get(sortedList.get(i-1)));
            else map.replace(sortedList.get(i), map.get(sortedList.get(i-1))+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append(map.get(list.get(i)) + " ");
        }
        System.out.println(sb);

    }
}
