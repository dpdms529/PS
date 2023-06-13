package p12911;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 다음 큰 숫자
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
public class Solution {

    public int solution(int n) {

        int bitCount = Integer.bitCount(n);

        while(true){
            if(bitCount == Integer.bitCount(++n)) break;
        }

        return n;
    }

    @ParameterizedTest
    @CsvSource({"78, 83", "15, 23"})
    void test(int n, int expected) {
        int result = solution(n);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
