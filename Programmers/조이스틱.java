import java.util.ArrayList;
import java.util.Arrays;

public class 조이스틱 {

    public static void main(String[] args) {
            System.out.println(solution("JAAANN"));
        }
    /*
    name	    return
    "JEROEN"	56
    "JAN"	    23
    */
    private static int solution(String name) {
        int answer = 0;
        char[] str = name.toCharArray();
        int strlen = name.length();
        int mv = strlen-1;
        int cursor = -1;

        for (int i=0; i<strlen; i++) {
            System.out.println("현재: "+str[i]);
            char c = str[i];

            // 상하 이동 횟수 구하기
            int tmp = Math.min(c-'A', 'Z'-c+1);
            answer += tmp;
            System.out.printf("%c: 누적 answer %d\n",c,answer);

            // 연속 A 구간 구하기
            int idx = i+1; // A 구간이 끝난 직후 지점
            while (idx<strlen && str[idx]=='A') {
                idx++;
            }

            // 좌우 이동 횟수 구하기
            // 1. 처음부터 끝까지 오른쪽으로 순서대로 이동
            System.out.println("1: "+mv);
            // 2. 오른쪽으로 이동하다가 왼쪽으로 쭉(맨뒤 이동 포함) 가는 것
            mv = Math.min(mv, i*2+strlen-idx);
            System.out.println("2: "+mv);
            // 3. 처음부터 왼쪽(맨뒤 이동 포함) 갔다가 다시 오른쪽으로 쭉 이동하는 것
            mv = Math.min(mv, (strlen-idx)*2+i);
            System.out.println("3: "+mv);
        }

        return answer+mv;
    }

}

