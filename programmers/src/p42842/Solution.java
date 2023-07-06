package p42842;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = yellow / i + 2;
                int y = i + 2;

                if ((x + y - 2) * 2 == brown) {
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }

        return answer;
    }
}
