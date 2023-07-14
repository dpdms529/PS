package p120903;

import java.util.Arrays;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;

        Arrays.sort(s1);
        Arrays.sort(s2);

        int start = 0;
        for (String s : s1) {
            for(int i = start;i< s2.length;i++) {
                if(s.equals(s2[i])) {
                    answer++;
                    start = i + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
