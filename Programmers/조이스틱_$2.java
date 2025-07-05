import java.util.*;

public class 조이스틱_$2 {

    public static void main(String[] args) {
            System.out.println(solution("JAAANN"));
        }

    private static int solution(String name) {
        int answer = 0;
        int len = name.length();
        int ud = 0;
        int lr = len-1;
        char[] str = name.toCharArray();

        for (int i=0; i<len; i++) {
            // 상하 체크
            ud += Math.min(str[i]-'A', 'Z'-str[i]+1);
        }

        for (int i=0; i<len-1; i++) {
            // 좌우 체크
            int aEnd = i;
            while (aEnd<len-1 && str[aEnd+1]=='A') {
                aEnd++;
            }
            aEnd++;
            lr = Math.min(lr, 2*(len-aEnd)+i);
            lr = Math.min(lr, 2*i+len-aEnd);
        }

        answer = ud+lr;
        return answer;
    }

}

