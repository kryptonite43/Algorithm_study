import java.util.*;
import java.util.stream.Collectors;

public class 큰_수_만들기_$2 {

    public static void main(String[] args) {
        System.out.println(solution("320137000008",8));
    }

    private static String solution(String number, int k) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        char[] num = number.toCharArray();
        int cnt = 0;

        for (int i=0; i<number.length(); i++) {
            while (cnt<k && !st.isEmpty() && st.peek()<(num[i]-'0')) {
                st.pollFirst();
                cnt++;
            }
            st.addFirst(num[i]-'0');
        }
        while (cnt<k) {
            st.pollFirst();
            cnt++;
        }
        ArrayList<Integer> ans = new ArrayList<>(st.stream().collect(Collectors.toList()));
        Collections.reverse(ans);
        StringBuilder sb = new StringBuilder(ans.stream().map(Object::toString).collect(Collectors.joining("")));
        return sb.toString();
    }
}

