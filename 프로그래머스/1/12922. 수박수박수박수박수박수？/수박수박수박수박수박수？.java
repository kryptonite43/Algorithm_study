import java.util.*;

class Solution {
    public String solution(int n) {
        String[] wat = {"수","박"};
        String waterm = "수박";
        String answer = "";
        for (int i=0; i<n/2; i++) {
            answer+=waterm;
        }
        if (n%2!=0) answer+=wat[0];
        return answer;
    }
}