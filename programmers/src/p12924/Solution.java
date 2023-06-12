package p12924;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 숫자의 표현
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */
public class Solution {
    public int solution(int n) {
        int answer = 0;

        int start = 1;
        int end = 1;
        int sum = 1;

        while(end <= n){
            if(sum <= n){
                if(sum == n){
                    answer++;
                }

                end++;
                sum += end;
            }else{
                sum -= start;
                start++;
            }
        }

        return answer;
    }

    @ParameterizedTest
    @CsvSource({"15, 4"})
    void test(int n, int expected){
        int result  = solution(n);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
