package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();

            String removedStr = str;
            String temp = remove(removedStr);

            while (removedStr.length() != temp.length()) {
                removedStr = temp;
                temp = remove(temp);
            }

            System.out.println(removedStr);
            System.out.println("#" + tc + " " + (N - removedStr.length()));
        }

    }

    private static String remove(String str) {
        return str.replaceAll("aa", "a")
                .replaceAll("bb", "b")
                .replaceAll("ab", "a")
                .replaceAll("ba", "b");
    }
}
