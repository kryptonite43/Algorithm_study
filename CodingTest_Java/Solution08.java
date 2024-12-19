import java.util.*;

public class Solution08 {

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));

    }
    public static boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    st.push('(');
                    break;
                case ')':
                    if (!st.isEmpty()) st.pop();
                    else return false;
            }
        }
        return st.isEmpty();
    }
}