import java.util.*;

public class Solution09 {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
        System.out.println(solution(1));
        System.out.println(solution(1000000000));
    }

    private static String solution(int decimal) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        while (decimal > 1) {
            st.push(decimal % 2);
            decimal /= 2;
        }
        st.push(decimal);
        while (!st.isEmpty()) {
            answer.append(st.pop());
        }
        return answer.toString();
    }
}