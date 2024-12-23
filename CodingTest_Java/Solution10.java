import java.util.*;

public class Solution10 {

    public static void main(String[] args) {
        System.out.println(solution("[)(]"));
    }
/*
s	        result
"[](){}"	3
"}]()[{"	2
"[)(]"	    0
"}}}"	    0
*/
    private static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i=0; i<s.length(); i++) {
            char deletedChar = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(deletedChar);

            if (checkString(sb)) answer++;
        }

        return answer;
    }
    private static boolean checkString(StringBuilder curStr) {
        // curStr를 스택에 하나씩 넣으면서 올바른 괄호인지 체크.
        Stack<Character> st = new Stack<>();

        for (int i=0; i<curStr.length(); i++) {
            char out = 0;
            char c = curStr.charAt(i);
            switch (c) {
                case '(', '{', '[' -> st.push(c);
                case ')' -> {
                    if (!st.isEmpty()) out = st.pop();
                    if (out != '(') return false;
                }
                case '}' -> {
                    if (!st.isEmpty()) out = st.pop();
                    if (out != '{') return false;
                }
                case ']' -> {
                    if (!st.isEmpty()) out = st.pop();
                    if (out != '[') return false;
                }
            }
        }
        return st.isEmpty();
    }
}