package p12933;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {

    public long solution(long n) {
        String[] digits = Long.toString(n)
                .split("");

        String answer = Arrays.stream(digits)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        return Long.parseLong(answer);
    }

    @ParameterizedTest
    @CsvSource({"118372, 873211"})
    void test(long n, long answer){
        Assertions.assertThat(solution(n)).isEqualTo(answer);
    }
}
