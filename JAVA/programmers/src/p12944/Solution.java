package p12944;

import java.util.Arrays;

class Solution {
    public static double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Solution.solution(arr));
    }
}