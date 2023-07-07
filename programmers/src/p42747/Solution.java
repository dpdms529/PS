package p42747;

import java.util.Arrays;

class Solution {
    public static int solution(int[] citations) {
        int h = 0;

        Arrays.sort(citations);
        int maxCitation = citations[citations.length-1];

        int start = 0;
        for(int i = 0;i<maxCitation;i++) {
            for(int j = start;j<citations.length;j++) {
                if(citations[j] >= i) {
                    if(citations.length - j >= i) {
                        h = i;
                    }

                    start = j;
                    break;
                }
            }
        }

        return h;
    }
}
