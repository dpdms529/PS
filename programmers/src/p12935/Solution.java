package p12935;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        int min = Arrays.stream(arr).min().getAsInt();

        for(int i = 0;i<arr.length;i++){
            if(arr[i] != min) answer.add(arr[i]);
        }

        if(answer.size() == 0){
            answer.add(-1);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
