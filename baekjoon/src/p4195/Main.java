package p4195;

import java.util.*;
import java.io.*;

public class Main {
    static Set<Set<String>> network;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int F = Integer.parseInt(br.readLine());
            network = new HashSet<>();

            for(int i = 0;i<F;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();



            }

        }
    }

}
