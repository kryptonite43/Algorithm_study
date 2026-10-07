import java.util.*;

class Solution {
    public int solution(String s) {
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
    
    public static boolean checkString(StringBuilder curStr) {
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