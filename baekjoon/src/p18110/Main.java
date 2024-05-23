package p18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] difficulty = new int[n];

        for (int i = 0; i < n; i++) {
            difficulty[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(difficulty);

        int remove = Math.round((float)n / 100 * 15);
        int start = remove;
        int end = n - remove;
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += difficulty[i];
        }

        int result = Math.round((float)sum / (end - start));
        System.out.println(result);
    }
}
