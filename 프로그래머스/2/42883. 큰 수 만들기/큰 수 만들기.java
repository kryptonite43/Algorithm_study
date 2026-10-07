import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
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