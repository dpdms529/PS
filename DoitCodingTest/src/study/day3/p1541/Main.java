package study.day3.p1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minus = br.readLine().split("-");

        int result = 0;

        for (int i = 0; i < minus.length; i++) {
            int sum = 0;

            if (minus[i].contains("+")) {
                String[] plus = minus[i].split("\\+");

                for (String num : plus) {
                    sum += Integer.parseInt(num);
                }
            } else {
                sum = Integer.parseInt(minus[i]);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }

        }

        System.out.println(result);

    }
}
