import java.util.ArrayList;
import java.util.Arrays;

public class 점_찍기 {

    public static void main(String[] args) {
        System.out.println(solution(3,10));
    }

    private static long solution(int k, int d) {
        long answer = 0, limit;
        long dd = (long) d * d;
        System.out.println(dd);
        for (int x = 0; x <= d; x += k) {
            long xx = (long) x * x;
            System.out.println(xx);
            limit = (long) Math.sqrt(dd - xx);

            answer += limit / k + 1;
            System.out.println(limit + " " + answer);
        }

        return answer;
    }
}

