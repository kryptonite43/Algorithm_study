import java.util.*;

public class 올바른_괄호 {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            }
            else { // ')' 일 시
                if (st.isEmpty())
                    return false;
                else
                    st.pop();
            }
        }
        return st.isEmpty();
    }
}
