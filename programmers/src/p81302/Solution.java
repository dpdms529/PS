package p81302;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 거리두기 확인하기
 * level2
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */
public class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {};

        for(String[] place : places){

        }

        return answer;
    }

    int isSatisfyDistance(String[] place){
        List<int[]> personPositions = getPersonPositions(place);

        for(int[] poistion : personPositions){

        }

        return 0;
    }

    List<int[]> getPersonPositions(String[] place){
        List<int[]> positions = new ArrayList<>();

        for(int i = 0;i<place.length;i++){
            for(int j = 0;j<place[i].length();j++){
                if(place[i].charAt(j) == 'P'){
                    positions.add(new int[]{i,j});
                }
            }
        }

        return positions;
    }

    int getDistance(int y1, int x1, int y2, int x2){
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
}
