import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayDeque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<progresses.length; i++) {
            int days = (100 - progresses[i])/speeds[i] + ((100 - progresses[i])%speeds[i] == 0?0:1);
            q.addLast(days);
        }
        while (!q.isEmpty()) {
            int cnt = 0;
            int front = q.peek();
            while (!q.isEmpty() && front >= q.peek()) {
                q.pollFirst();
                cnt++;
            }
            res.add(cnt);
        }
        answer = res.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}