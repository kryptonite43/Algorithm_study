import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tan) {
        int answer = 0;
    
        int[] cnt = new int[tan.length+10];
        Arrays.sort(tan);
        
        int cur = tan[0], curind = 0;
        for (int i=0; i<tan.length; i++) {
            if (cur!=tan[i]) {
                cur=tan[i];
                curind++;   
            }
            cnt[curind]++;
        }
        Integer[] cnt2 = Arrays.stream(cnt).boxed().toArray(Integer[]::new);
        Arrays.sort(cnt2, Collections.reverseOrder());
        int[] cntr = Arrays.stream(cnt2).mapToInt(i->i).toArray();
        int sum = 0;
        for (int i=0; i<cntr.length; i++) {
            sum += cntr[i];
            if (sum>=k) {
                return i+1;
            }
        }
    
        
        return answer;
    }
}