package p12941;

import java.util.Arrays;

/**
 * 최솟값 만들기
 * level 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class Solution {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;

        for(int i = 0;i<len;i++){
            answer += A[i] * B[len - 1 - i];
        }

        return answer;
    }
}
