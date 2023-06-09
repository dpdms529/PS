package p120583;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class Solution {
    public int solution(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(value -> value == n)
                .count();
    }

    @ParameterizedTest
    @CsvSource(value = {"[1, 1, 2, 3, 4, 5]:1:2", "[0, 2, 3, 4]:1:0"}, delimiter = ':')
    void test(String arrayStr, int n, int expected){
        int[] array = Arrays.stream(arrayStr.substring(1, arrayStr.length() - 1)
                        .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = solution(array, n);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
