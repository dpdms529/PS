package p120808;

import java.util.Arrays;

class Fraction{
    int denum;
    int num;

    public Fraction(int denum, int num){
        this.denum = denum;
        this.num = num;
    }

    public int[] add(Fraction f){
        int[] result = new int[2];
        int lcm = getLcm(num, f.num);

        result[0] = denum * (lcm/ num) + f.denum * (lcm / f.num);
        result[1] = lcm;

        int gcd = getGcd(result[0], result[1]);

        result[0] /= gcd;
        result[1] /= gcd;

        return result;
    }

    private int getLcm(int num1, int num2){
        int gcd = getGcd(num1, num2);
        return num1 * num2 / gcd;
    }

    private int getGcd(int num1, int num2){
        return  num1 >= num2 ? findGcd(num1, num2) : findGcd(num2, num1);
    }

    private int findGcd(int big, int small){
        int r = big % small;

        while(r != 0){
            big = small;
            small = r;
            r = big % small;
        }

        return small;
    }
}

class Solution {
    public static int[] solution(int denum1, int num1, int denum2, int num2) {
        Fraction fraction1 = new Fraction(denum1, num1);
        Fraction fraction2 = new Fraction(denum2, num2);

        return fraction1.add(fraction2);
    }

    public static void main(String[] args) {
        int denum1 = 9, num1 = 2, denum2 = 1, num2 = 3;
        Arrays.stream(solution(denum1, num1, denum2, num2)).forEach(System.out::println);
    }
}
