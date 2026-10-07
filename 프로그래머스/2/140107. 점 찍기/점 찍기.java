import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0, limit;
        long dd = (long)d*d;

        for (int x=0; x<=d; x +=k) {
            long xx = (long)x*x;
            limit = (long)Math.sqrt(dd-xx);
            answer += limit/k+1;
        }
        
        return answer;
    }
}