package p9019;

import java.util.*;
import java.io.*;

class Pair{
        String cmd;
        int value;
        public Pair(String cmd, int value){
                this.cmd = cmd;
                this.value = value;
        }
}

public class p9019 {
        public static void main(String[] args)throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int t = Integer.parseInt(br.readLine());
                String[] cmd = {"D","S","L","R"};
                for(int i = 0;i<t;i++){
                        StringTokenizer st = new StringTokenizer(br.readLine());
                        int a = Integer.parseInt(st.nextToken());
                        int b = Integer.parseInt(st.nextToken());
                        boolean[] visited = new boolean[10000];
                        Queue<Pair> queue = new LinkedList<>();
                        queue.offer(new Pair("", a));
                        check : while(!queue.isEmpty()){
                                Pair p = queue.poll();
                                int val = p.value;
                                for(String s : cmd){
                                        StringBuilder sb = new StringBuilder(p.cmd);
                                        int tmp = val;
                                        int share;
                                        int remainder;
                                        switch (s){
                                                case "D":
                                                        sb.append("D");
                                                        tmp = val*2;
                                                        if(tmp>9999) tmp = tmp%10000;
                                                        break;
                                                case "S":
                                                        sb.append("S");
                                                        tmp = val-1;
                                                        if(tmp==-1) tmp = 9999;
                                                        break;
                                                case "L":
                                                        sb.append("L");
                                                        share = val/1000;
                                                        remainder = val%1000;
                                                        tmp = remainder*10 + share;
                                                        break;
                                                case "R":
                                                        sb.append("R");
                                                        share = val/10;
                                                        remainder = val%10;
                                                        tmp = remainder*1000 + share;
                                                        break;
                                        }
                                        if(tmp == b){
                                                System.out.println(sb);
                                                break check;
                                        }
                                        if(!visited[tmp]){
                                                visited[tmp] = true;
                                                queue.offer(new Pair(sb.toString(), tmp));
                                        }
                                }
                        }
                }

        }
}
