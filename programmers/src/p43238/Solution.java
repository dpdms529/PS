package p43238;

class Solution {
    static final long MAX_PEOPLE = 1000000000;
    static final long MAX_TIME = 1000000000;

    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = MAX_PEOPLE * MAX_TIME;

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                answer = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }


        return answer;
    }
}
