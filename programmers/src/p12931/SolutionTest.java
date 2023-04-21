package p12931;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class SolutionTest {

    Solution solution;
    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @CsvSource(value = {"123, 6", "987, 24"})
    void solution(int n, int answer) {
        int result = solution.solution(n);
        assertThat(result).isEqualTo(answer);
    }
}