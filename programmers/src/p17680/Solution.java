package p17680;

import java.util.*;

/**
 * [1차] 캐시
 * level2
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
public class Solution {
    final int CACHE_HIT = 1;
    final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> cache = new LinkedList<>();

        for(String city : cities){
            city = city.toLowerCase();

            if(cache.contains(city)){
                answer += CACHE_HIT;

                cache.remove(cache.indexOf(city));
                cache.add(0, city);
            }else{
                answer += CACHE_MISS;
                cache.add(0, city);

                if(cache.size() > cacheSize){
                    cache.remove(cacheSize);
                }
            }
        }

        return answer;
    }
}
