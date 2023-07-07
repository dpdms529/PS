package p120830;

class Solution {
    static final int SHEEP = 12000;
    static final int DRINK = 2000;
    static final int SERVICE = 10;
    public int solution(int n, int k) {
        return n * SHEEP + (k - n / SERVICE) * DRINK;
    }
}