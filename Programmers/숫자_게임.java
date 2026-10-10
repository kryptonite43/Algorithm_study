import java.util.*;

public class 숫자_게임 {
    public int solution(int[] a, int[] b) {
        int answer = 0, ind = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i=0; i<a.length; i++) {
            while (a[i]>=b[ind] && ind<a.length-1) ind++;
            if (a[i]<b[ind]) {
                answer++;
                ind++;
            }
            if (ind>=a.length) break;
        }
        return answer;
    }
}