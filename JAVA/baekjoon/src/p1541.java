import java.io.*;

public class p1541 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input : 주어진 식을 -를 기준으로 나눈 것
        String[] input = br.readLine().split("-");

        // result : 주어진 식의 최소값
        int result = 0;

        // input의 요소가 +를 포함한 식이면 + 기준으로 나눠 구해진 숫자들을 모두 더해 그 값을 sum에 저장
        // input의 요소가 숫자면 그 값을 sum에 저장
        // i = 0일 경우 result에 sum을 더해주고, 아닐 경우 result에 sum을 빼준다.
        for(int i = 0;i<input.length;i++){
            int sum = 0;
            if(input[i].contains("+")){
                String[] arr = input[i].split("\\+");
                for(int j = 0;j<arr.length;j++){
                    sum += Integer.parseInt(arr[j]);
                }
            }else{
                sum += Integer.parseInt(input[i]);
            }
            if(i == 0) result += sum;
            else result -= sum;
        }

        // result 출력
        System.out.println(result);
    }
}
