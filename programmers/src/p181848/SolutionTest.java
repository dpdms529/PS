package p181848;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void init(){
        solution = new Solution();
    }

    @ParameterizedTest
    @CsvSource(value = {"10, 10", "8542, 8542"})
    void solution(String n_str, int answer) {
        int result = solution.solution(n_str);
        assertThat(result).isEqualTo(answer);
    }
}