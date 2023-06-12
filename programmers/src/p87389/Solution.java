package p87389;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 나머지가 1이 되는 수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87389
 */
public class Solution {
    public int solution(int n) {
        for(int i = 2;i*i<=n;i++){
            if(n % i == 1){
                return i;
            }
        }

        return n - 1;
    }

    @ParameterizedTest
    @CsvSource({"10, 3", "12, 11", "49, 2", "32, 31"})
    void test(int n, int expected){
        int result = solution(n);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
