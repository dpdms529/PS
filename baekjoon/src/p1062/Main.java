package p1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static String[] word;
    public static boolean[] visited = new boolean[26];
    public static char[] alph;
    public static int max = 0;

    public static void dfs(int depth, int index){
        if(depth==k){
            int cnt = 0;
            for(int i = 0;i<n;i++){
                int check = 0;
                for(int j = 4;j<word[i].length()-4;j++){
                    char c = word[i].charAt(j);
                    for(int l = 0;l<k;l++){
                        if(c == alph[l]) check++;
                    }
                }
                if(check == word[i].length()-8) cnt++;
            }
            if(cnt > max) max = cnt;
        }else{
            for(int i = index;i<26;i++){
                if(!visited[i]){
                    visited[i] = true;
                    alph[depth] = (char)('a' + i);
                    dfs(depth+1, i+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        word = new String[n];
        for(int i = 0;i<n;i++){
            word[i] = br.readLine();
        }

        if(k>4){
            alph = new char[k];
            char[] chars = {'a','c','i','n','t'};
            for(int i = 0;i<5;i++){
                alph[i] = chars[i];
                visited[chars[i]-97] = true;
            }
            dfs(5,1);
        }
        System.out.println(max);
    }
}