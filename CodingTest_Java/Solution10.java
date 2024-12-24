import java.util.*;

public class Solution10 {

    public static void main(String[] args) {
        System.out.println(solution("[)(]"));
    }

    private static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i=0; i<s.length(); i++) {
            char deletedChar = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(deletedChar);

            if (checkString(sb)) answer++;
        }
        /* 다른 풀이
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        s += s; // 원본 문자열을 2번 이어 붙여 회전을 간편하게 구현 (like: sliding window)

        int answer = 0;

        A:
        for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (int j = i; j < i + n; i++) { // 원본 문자열에 해당하는 부분만 체크
                char c = s.charAt(j);

                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }

            if (stack.isEmpty())
                answer++;
        }
        */
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