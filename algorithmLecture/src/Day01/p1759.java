package Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1759 {
    public static int l, c;
    public static char[] chars;
    public static boolean[] visited;
    public static char[] pwd;
    public static StringBuilder sb = new StringBuilder();

    public static boolean check(){
        int consonant = 0, vowel = 0;
        for(int i = 0;i<l;i++){
            switch(pwd[i]){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowel++;
                    break;
                default:
                    consonant++;
                    break;
            }
        }
        if(vowel>0 && consonant>1) return true;
        else return false;
    }

    public static void dfs(int depth, int index){
        if(depth==l){
            if(check()){
                for(int i = 0;i<l;i++){
                    sb.append(pwd[i]);
                }
                sb.append("\n");
            }
            return;
        }else{
            for(int i = index;i<c;i++){
                if(!visited[i]){
                    visited[i] = true;
                    pwd[depth] = chars[i];
                    dfs(depth+1, i+1);
                    visited[i] = false;
                }
            }
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        chars = new char[c];
        visited = new boolean[c];
        pwd = new char[l];
        for(int i = 0;i<c;i++){
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        dfs(0,0);
        System.out.println(sb);
    }
}
