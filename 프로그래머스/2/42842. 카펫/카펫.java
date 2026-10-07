import java.util.*;
import java.util.stream.*;

class Solution {
    public Integer[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x, y;
        for (int i=1; i<=yellow; i++) {
            if (yellow%i !=0)
                continue;
            else {
                int xcand = yellow/i +2;
                int ycand = i + 2;
                if (brown != (2*(xcand+ycand)-4)) {
                    continue;
                }
                else {
                    answer[0] = xcand;
                    answer[1] = ycand;
                    Integer[] ans = Arrays.stream(answer).boxed().toArray(Integer[]::new);
                    Arrays.sort(ans, Collections.reverseOrder());
                    return ans;
                }
            }
        }
        
        return new Integer[] {};
    }
}