package p92335;

class Solution {
    public static int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n % k);
            n = n / k;
        }
        sb.reverse();
        String[] nums = sb.toString().split("0+");
        for(String s : nums){
            if(isPrime(Long.parseLong(s))){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isPrime(long n){
        if(n<2) return false;
        for(long i = 2;i*i<=n;i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
    }
}
