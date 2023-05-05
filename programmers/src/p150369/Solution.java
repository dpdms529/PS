package p150369;

import java.util.Stack;

/**
 * 택배 배달과 수거하기
 * level2
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 */
public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> deliveryStack = getStack(deliveries);
        Stack<Integer> pickupStack = getStack(pickups);

        while(!deliveryStack.isEmpty() || !pickupStack.isEmpty()){
            int lastDelivery = deliveryStack.isEmpty() ? 0 : deliveryStack.peek();
            int lastPickup = pickupStack.isEmpty() ? 0 : pickupStack.peek();

            for(int i = 0;i<cap;i++){
                if(!deliveryStack.isEmpty()) deliveryStack.pop();
                if(!pickupStack.isEmpty()) pickupStack.pop();
            }

            answer += Math.max(lastDelivery, lastPickup) * 2L;
        }

        return answer;
    }

    Stack<Integer> getStack(int[] array){
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i];j++){
                stack.push(i+1);
            }
        }

        return stack;
    }
}
