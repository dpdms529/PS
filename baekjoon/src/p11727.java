import java.io.*;

public class p11727 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n : 직사각형 가로 길이
        int n = Integer.parseInt(br.readLine());

        // dp : 2 x i 크기의 직사각형을 타일로 채우는 방법의 수를 가지는 배열
        int[] dp = new int[1000];

        // 2 x 1 크기의 직사각형을 타일로 채우는 방법은 1가지
        dp[0] = 1;

        // 2 X 2 크기의 직사각형을 타일로 채우는 방법은 3가지
        dp[1] = 3;
        
        // n>=3인 경우 직사각형을 타일로 채우는 방법의 수는 dp[i-1] + 2*dp[i-2]
        for(int i = 2;i<n;i++){
            dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
        }
        
        // dp[n-1] 출력
        System.out.println(dp[n-1]);
    }
}
