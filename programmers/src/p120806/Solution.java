package p120806;

class Solution {
    public static int solution(int num1, int num2) {
        return num1 * 1000 / num2;
    }

    public static void main(String[] args) {
        int num1 = 1, num2 = 16;
        System.out.println(solution(num1, num2));
    }
}