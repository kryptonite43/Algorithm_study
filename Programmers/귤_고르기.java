import java.util.*;

public class 귤_고르기 {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
/*
k	tangerine	result
6	[1, 3, 2, 5, 4, 5, 2, 3]	3
4	[1, 3, 2, 5, 4, 5, 2, 3]	2
2	[1, 1, 1, 1, 2, 2, 2, 3]	1
*/
    public static int solution(int k, int[] tan) {
        int answer = 0;
        int[] cnt = new int[tan.length + 10];
        Arrays.sort(tan);

        int cur = tan[0], curind = 0;
        for (int i = 0; i < tan.length; i++) {
            if (cur != tan[i]) {
                cur = tan[i];
                curind++;
            }
            cnt[curind]++;
        }
        Integer[] cnt2 = Arrays.stream(cnt).boxed().toArray(Integer[]::new);
        Arrays.sort(cnt2, Collections.reverseOrder());
        int[] cntr = Arrays.stream(cnt2).mapToInt(i -> i).toArray();
        int sum = 0;
        for (int i = 0; i < cntr.length; i++) {
            sum += cntr[i];
            if (sum >= k) {
                return i + 1;
            }
        }
        return answer;
    }
}

