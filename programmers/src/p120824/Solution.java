package p120824;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];

        Map<Boolean, Long> map = Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.groupingBy(num -> num % 2 == 0, Collectors.counting()));

        answer[0] = map.getOrDefault(true, 0L).intValue();
        answer[1] = map.getOrDefault(false, 0L).intValue();

        return answer;
    }
}
