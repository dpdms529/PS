package p42576;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            int cnt = map.get(c);

            if(cnt - 1 == 0) {
                map.remove(c);
            }else {
                map.put(c, cnt - 1);
            }
        }

        return map.keySet()
                .iterator()
                .next();
    }
}