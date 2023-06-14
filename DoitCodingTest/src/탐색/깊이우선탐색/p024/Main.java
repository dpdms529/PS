package 탐색.깊이우선탐색.p024;

import java.io.*;

/**
 * 신기한 소수
 * https://www.acmicpc.net/problem/2023
 */
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] prime = {2, 3, 5, 7};

        for(int p : prime){
            findInterestingNum(p, 1);
        }

    }

    static void findInterestingNum(int num, int d){
        if(d == N){
            System.out.println(num);
        }else{
            for(int i = 1;i<10;i+=2){
                int nextNum = num * 10 + i;
                if(isPrime(nextNum)){
                    findInterestingNum(nextNum, d + 1);
                }
            }
        }
    }

    static boolean isPrime(int num){
        for(int i = 2;i*i<=num;i++){
            if(num%i == 0){
                return false;
            }
        }

        return true;
    }
}
