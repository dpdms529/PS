package p120809;

import java.util.Arrays;

class Solution {
    public static int[] solution(int[] numbers) {
        return Arrays.stream(numbers)
                .map(value -> value*2)
                .toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 100, -99, 1, 2, 3};
        Arrays.stream(solution(numbers))
                .forEach(System.out::println);
    }
}
