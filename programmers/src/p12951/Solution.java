package p12951;


import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static String solution(String s) {
        return Arrays.stream(s.toLowerCase()
                .split(" ", -1))
                .map(word -> word.isBlank() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(solution("people  3unFollowed me    "));
    }
}
