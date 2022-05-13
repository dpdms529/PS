package KakaoIntern2022;

import java.util.*;

public class p2 {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static boolean count(Queue<Integer> ql, Queue<Integer> qr){
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0;i<ql.size();i++){
            int item = ql.poll();
            sum1+=item;
            ql.offer(item);
        }
        for(int i = 0;i<qr.size();i++){
            int item = qr.poll();
            sum2+=item;
            qr.offer(item);
        }
        if(sum1 == sum2) {
            System.out.println("sum1:" + sum1);
            System.out.println("sum2:" + sum2);
            return true;
        }else if(ql.isEmpty() || qr.isEmpty() || (ql == q1 && qr== q2)){
            return false;
        }
        else{
            Queue<Integer> ql1 = new LinkedList<>(ql);
            Queue<Integer> qr1 = new LinkedList<>(qr);
            Queue<Integer> ql2 = new LinkedList<>(ql);
            Queue<Integer> qr2 = new LinkedList<>(qr);

            ql1.offer(qr1.poll());
            qr2.offer(ql2.poll());
            boolean result1 = count(ql1,qr1);
            System.out.println("result1:"+result1);
            boolean result2 = count(ql2,qr2);
            System.out.println("result2:"+result2);

            return result1 || result2;
        }
    }
    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        for(int i = 0;i<queue1.length;i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        if(count(q1,q2)){

        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println(solution(queue1, queue2));
    }

}
