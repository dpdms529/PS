import java.io.*;

public class p2579 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n : 계단의 개수
        int n = Integer.parseInt(br.readLine());

        // arr :  각 계단에 쓰인 점수를 가지고 있는 배열
        int[] arr = new int[n+1];

        // dp : 각 계단을 밟을 때 얻을 수 있는 최고 점수를 가지는 배열
        int[] dp = new int[n+1];

        // 계단에 쓰여 있는 점수 arr에 저장
        for(int i = 1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 첫번째 계단을 밟을 때 얻을 수 있는 최대 점수는 첫번째 계단에 적힌 점수
        dp[1] = arr[1];
        if(n>=2){
            // 두번째 계단을 밟을 때 얻을 수 있는 최대 점수는 첫번째 계단에 적힌 점수 + 두번째 계단에 적힌 점수
            dp[2] = arr[1] + arr[2];
            // 세번째 계단 이상부터 얻을 수 있는 최대 점수는 dp[i-2] + arr[1]와 dp[i-3] + arr[i-1] + arr[i] 중 더 큰 수
            for(int i = 3;i<=n;i++){
                dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
            }
        }

        // dp[n] 출력
        System.out.println(dp[n]);
    }
}
