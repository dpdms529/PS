package KakaoIntern2022;

import java.util.*;

class p1 {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> cnt = new HashMap<>();
        cnt.put('R',0);
        cnt.put('T',0);
        cnt.put('C',0);
        cnt.put('F',0);
        cnt.put('J',0);
        cnt.put('M',0);
        cnt.put('A',0);
        cnt.put('N',0);
        for(int i = 0;i<survey.length;i++){
            char cate1 = survey[i].charAt(0);
            char cate2 = survey[i].charAt(1);
            switch(choices[i]){
                case 1:
                    cnt.replace(cate1, cnt.get(cate1)+3);
                    break;
                case 2:
                    cnt.replace(cate1, cnt.get(cate1)+2);
                    break;
                case 3:
                    cnt.replace(cate1, cnt.get(cate1)+1);
                    break;
                case 4: break;
                case 5:
                    cnt.replace(cate2, cnt.get(cate2)+1);
                    break;
                case 6:
                    cnt.replace(cate2, cnt.get(cate2)+2);
                    break;
                case 7:
                    cnt.replace(cate2, cnt.get(cate2)+3);
                    break;
            }
        }
        char chracter[][] = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        for(int i = 0;i<4;i++){
            int v1 = cnt.get(chracter[i][0]);
            int v2 = cnt.get(chracter[i][1]);
            if(v1>=v2) answer += chracter[i][0];
            else answer += chracter[i][1];
        }
        return answer;
    }

    public static void main(String[] args) {
        String survey[] = {"TR", "RT", "TR"};
        int choices[] = {7, 1, 3};
        System.out.println(solution(survey, choices));
    }
}