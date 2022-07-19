package Day02.p2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> subA = new ArrayList<>();
        ArrayList<Long> subB = new ArrayList<>();

        for(int i = 0;i<n;i++){
            long sum = A[i];
            subA.add(sum);
            for(int j = i+1;j<n;j++){
                sum += A[j];
                subA.add(sum);
            }
        }

        for(int i = 0;i<m;i++){
            long sum = B[i];
            subB.add(sum);
            for(int j = i+1;j<m;j++){
                sum += B[j];
                subB.add(sum);
            }
        }

        Collections.sort(subA);
        Collections.sort(subB, Collections.reverseOrder());

        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while(true){
            long curA = subA.get(ptA);
            long target = T - curA;
            long curB = subB.get(ptB);
            if(curB==target){
                long cntA = 0;
                long cntB = 0;
                while(ptA < subA.size() && subA.get(ptA)==curA){
                    cntA++;
                    ptA++;
                }
                while(ptB < subB.size() && subB.get(ptB)==target){
                    cntB++;
                    ptB++;
                }
                result += cntA * cntB;
            }else if(curB>target){
                ptB++;
            }else{
                ptA++;
            }
            if(ptA==subA.size() || ptB==subB.size()) break;
        }
        System.out.println(result);
    }
}
