package p43165;

class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return cnt;
    }

    public void dfs(int[] numbers, int target, int sum, int depth) {
        if(depth == numbers.length) {
            if(sum == target) {
                cnt++;
            }
        }else {
            sum += numbers[depth];
            dfs(numbers, target, sum, depth+1);
            sum -= numbers[depth] * 2;
            dfs(numbers, target, sum, depth+1);
        }
    }
}
