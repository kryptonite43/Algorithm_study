import java.util.*;


class Solution
{
    public int solution(String s) {
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