package p7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static TreeMap<Integer, Integer> treeMap;
    static final String INSERT = "I";
    static final String DELETE = "D";
    static final int MAX = 1;
    static final int MIN = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            init();
            int k = Integer.parseInt(br.readLine());

            for(int i = 0;i<k;i++) {
                String[] cmd = br.readLine().split(" ");

                if (cmd[0].equals(INSERT)) {
                    int num = Integer.parseInt(cmd[1]);
                    insert(num);
                } else if (cmd[0].equals(DELETE)) {
                    int num = Integer.parseInt(cmd[1]);
                    delete(num);
                }
            }

            if(treeMap.isEmpty()) {
                System.out.println("EMPTY");
            }else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }

    static void init() {
        treeMap = new TreeMap<>();
    }

    static void insert(int num) {
        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
    }

    static void delete(int num) {
        if(!treeMap.isEmpty()) {
            int key = 0;

            if(num == MAX) {
                key = treeMap.lastKey();
            }else if(num == MIN) {
                key = treeMap.firstKey();
            }

            if(treeMap.get(key) > 0) {
                treeMap.put(key, treeMap.get(key) - 1);

                if(treeMap.get(key) == 0) {
                    treeMap.remove(key);
                }
            }else {
                treeMap.remove(key);
            }
        }
    }
}
