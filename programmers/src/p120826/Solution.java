package p120826;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Solution {
    public String solution(String my_string, String letter) {
        return my_string.replaceAll(letter, "");
    }

    @ParameterizedTest
    @CsvSource({"abcdef, f, abcde", "BCBdbe, B, Cdbe"})
    void test(String my_string, String letter, String expected){
        String result = solution(my_string, letter);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
