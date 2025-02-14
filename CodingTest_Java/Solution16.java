import java.util.*;

// 기능개발 https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class Solution16 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55},new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99},new int[]{1, 1, 1, 1, 1, 1})));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayDeque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<progresses.length; i++) {
            int days = (100 - progresses[i])/speeds[i] + ((100 - progresses[i])%speeds[i] == 0?0:1);
            q.addLast(days);
        }
        System.out.println(q);
        while (!q.isEmpty()) {
            int cnt = 0;
            int front = q.peek();
            while (!q.isEmpty() && front >= q.peek()) {
                q.pollFirst();
                cnt++;
            }
            res.add(cnt);
            System.out.println(q);
        }
        answer = res.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}