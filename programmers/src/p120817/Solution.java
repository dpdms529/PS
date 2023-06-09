package p120817;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class Solution {
    public double solution(int[] numbers) {
       return Arrays.stream(numbers)
                .average()
                .getAsDouble();
    }

    @ParameterizedTest
    @CsvSource(value = {"{1, 2, 3, 4, 5, 6, 7, 8, 9, 10} : 5.5", "{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99} : 94.0"}, delimiter = ':')
    void test(String numbersStr, double expected){
        int[] numbers = Arrays.stream(numbersStr.substring(1, numbersStr.length()-1)
                        .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        double result = solution(numbers);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
