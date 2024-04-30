package p2143.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = getArray(n, br.readLine());
        List<Long> sumA = getSumArray(n, A, false);

        int m = Integer.parseInt(br.readLine());
        int[] B = getArray(m, br.readLine());
        List<Long> sumB = getSumArray(m, B, true);

        long result = 0;
        int ptA = 0;
        int ptB = 0;

        while (true) {
            long curA = sumA.get(ptA);
            long target = T - curA;
            long curB = sumB.get(ptB);

            if (target == curB) {
                long cntA = 0;
                long cntB = 0;

                while (ptA < sumA.size() && curA == sumA.get(ptA)) {
                    cntA++;
                    ptA++;
                }

                while (ptB < sumB.size() && curB == sumB.get(ptB)) {
                    cntB++;
                    ptB++;
                }

                result += cntA * cntB;
            } else if (curB > target) {
                ptB++;
            } else {
                ptA++;
            }

            if (ptA == sumA.size() || ptB == sumB.size()) break;
        }

        System.out.println(result);

    }

    private static List<Long> getSumArray(int n, int[] arr, boolean reverseOrder) {
        List<Long> sumArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long sum = arr[i];
            sumArr.add(sum);

            for (int j = i + 1; j < n; j++) {
                sum += arr[j];
                sumArr.add(sum);
            }
        }

        if (reverseOrder) Collections.sort(sumArr, Collections.reverseOrder());
        else Collections.sort(sumArr);

        return sumArr;
    }

    private static int[] getArray(int n, String arrStr) {
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(arrStr);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return arr;
    }
}
