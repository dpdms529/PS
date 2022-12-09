package p120820;

class Solution {
    public static int solution(int age) {
        int year = 2022;
        return year - age + 1;
    }

    public static void main(String[] args) {
        int age = 23;
        System.out.println(solution(age));
    }
}