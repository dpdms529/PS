package p1845;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int select = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if(map.size() >= select) return select;
        else return map.size();
    }
}
