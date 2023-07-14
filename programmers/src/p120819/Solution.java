package p120819;

class Solution {
    static final int ICE_AMERICANO_PRICE = 5500;
    public int[] solution(int money) {
        int cnt = money / ICE_AMERICANO_PRICE;
        int change = money % ICE_AMERICANO_PRICE;

        return new int[]{cnt, change};
    }
}
