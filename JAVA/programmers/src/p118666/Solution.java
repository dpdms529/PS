package p118666;

import java.util.*;

public class Solution {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer>[] map = new HashMap[4];
        for(int i = 0;i<4;i++){
            map[i] = new HashMap<>();
        }
        map[0].put('R',0);
        map[0].put('T',0);
        map[1].put('F',0);
        map[1].put('C',0);
        map[2].put('M',0);
        map[2].put('J',0);
        map[3].put('A',0);
        map[3].put('N',0);

        for(int i = 0;i<survey.length;i++){
            int idx = -1;
            char[] type = survey[i].toCharArray();
            switch(survey[i]){
                case "RT":
                case "TR":
                    idx = 0;
                    break;
                case "FC":
                case "CF":
                    idx = 1;
                    break;
                case "MJ":
                case "JM":
                    idx = 2;
                    break;
                case "AN":
                case "NA":
                    idx = 3;
                    break;
            }
            switch(choices[i]){
                case 1:
                    map[idx].put(type[0], map[idx].get(type[0])+3);
                    break;
                case 2:
                    map[idx].put(type[0], map[idx].get(type[0])+2);
                    break;
                case 3:
                    map[idx].put(type[0], map[idx].get(type[0])+1);
                    break;
                case 4:
                    break;
                case 5:
                    map[idx].put(type[1], map[idx].get(type[1])+1);
                    break;
                case 6:
                    map[idx].put(type[1], map[idx].get(type[1])+2);
                    break;
                case 7:
                    map[idx].put(type[1], map[idx].get(type[1])+3);
                    break;
            }

        }
        StringBuilder sb = new StringBuilder();
        Set<Character> set[] = new Set[4];
        for(int i = 0;i<4;i++){
            set[i] = map[i].keySet();
            char type = ' ';
            int score = -1;
            for(char t : set[i]){
                if(map[i].get(t) > score){
                    type = t;
                    score = map[i].get(t);
                }
            }
            sb.append(type);
        }
        answer = sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }
}
