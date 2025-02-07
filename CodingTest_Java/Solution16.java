import java.util.*;

// 기능개발 https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class Solution16 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55},new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99},new int[]{1, 1, 1, 1, 1, 1})));
    }
/*    progresses	            speeds	            return
      [93, 30, 55]	            [1, 30, 5]	        [2, 1]
      [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]*/
    private static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int count = 1, cur = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

        do {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if (cur == i && progresses[i] >= 100) {
                    q.push(progresses[i]);
                    cur++;
                }
            }
            if (q.size() != 0) {
                res.add(q.size());
                q.clear();
            }
            count++;
        } while (cur != progresses.length);

        answer = res.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}