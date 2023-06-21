package p12973;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

public class Solution {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty()){
                if(stack.peek() == s.charAt(i)) {
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        if(stack.isEmpty()) return 1;
        else return 0;
    }

    @ParameterizedTest
    @CsvSource({"baabaa, 1", "cdcd, 0", "aab, 0"})
    public void test(String s, int expected) {
        int result = solution(s);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
