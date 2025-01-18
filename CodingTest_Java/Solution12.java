import java.util.*;

public class Solution12 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{1,2,3,2,3})));
    }


    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        // 스택 원소는 index를 삽입한다. 그리고 st.top과 prices[i]를 비교한다.
        for (int i=0; i<prices.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
                continue;
            }
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) { // 가격이 하락함. 1,2,3,2,3
                int fix = st.pop();
                answer[fix] = i - fix;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int fin = st.pop();
            answer[fin] = prices.length-1 - fin;
        }
        return answer;
    }
}