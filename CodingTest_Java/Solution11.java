import java.util.*;
import java.util.stream.Collectors;

public class Solution11 {

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
    private static void makeString(ArrayDeque<Character> stc) {
        StringBuilder sb = new StringBuilder(stc.stream().map(Object::toString).collect(Collectors.joining("")));
        System.out.println(sb.reverse().toString());
    }

    private static int solution(String s) {
        int answer = -1;
        ArrayDeque<Character> st = new ArrayDeque<>();
        char[] str = s.toCharArray();

        for (char c: str) {
            if (!st.isEmpty() && (st.peek() == c)) { // 스택에 원소가 들어있음
                st.pop();
                continue;
            }
            st.push(c);
        }
        answer = (st.isEmpty())?1:0;
        return answer;
    }
}
