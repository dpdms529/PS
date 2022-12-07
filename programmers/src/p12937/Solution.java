package p12937;

class Solution {
    public static String solution(int num) {
        if(num % 2 == 0){
            return "Even";
        }else{
            return "Odd";
        }
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(solution(num));
    }
}