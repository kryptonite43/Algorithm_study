import java.util.*;

public class Solution12_a {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{2,1,3,4,1})));
    }

    private static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i=1; i<len; i++) {
            while (!st.isEmpty() && prices[i]<prices[st.peek()]) {
                int top = st.peek();
                int x = st.pop();
                answer[top] = i - x;
                //System.out.printf("answer[%d] = %d\n",top,answer[top]);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int t = st.peek();
            answer[t] = len - st.pop()-1;
            //System.out.printf("answer[%d] = %d\n",t,answer[t]);
        }
        return answer;
    }
}