package p12945;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Solution {
    static final int DIV = 1234567;
    static final int MAX = 100001;
    public int solution(int n) {

        int[] fivo = new int[MAX];

        fivo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fivo[i] = (fivo[i-2] + fivo[i-1]) % DIV;
        }

        return fivo[n];
    }

    @ParameterizedTest
    @CsvSource({"3,2", "5,5"})
    void test(int n, int expected) {
        int result = solution(n);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
