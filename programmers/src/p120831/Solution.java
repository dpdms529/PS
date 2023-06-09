package p120831;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 2;i<=n;i+=2){
            answer += i;
        }

        return answer;
    }

    @ParameterizedTest
    @CsvSource({"10,30", "4,6"})
    void test(int n, int expected){
        int result = solution(n);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
