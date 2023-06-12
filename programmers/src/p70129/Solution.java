package p70129;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")){
            answer[0]++;

            int c = s.replace("0", "").length();
            answer[1] += s.length() - c;

            s = Integer.toBinaryString(c);
        }

        return answer;
    }

    @ParameterizedTest
    @CsvSource({"110010101001, 3, 8", "01110, 3, 3", "1111111, 4, 1"})
    void test(String s, int change, int zero){
        int[] expected = {change, zero};
        int[] result = solution(s);

        Assertions.assertThat(result).isEqualTo(expected);
    }

}
