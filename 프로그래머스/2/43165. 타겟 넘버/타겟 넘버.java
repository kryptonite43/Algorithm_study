import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>(); // add, poll
        q.add(0);
        for (int i=0; i<numbers.length; i++) {
            int size = q.size();
            for (int j=0; j<size; j++) {
                int currentsum = q.poll();
                q.add(currentsum+numbers[i]);
                q.add(currentsum-numbers[i]);
            }
        }
        while(!q.isEmpty()) {
            if (q.poll()==target) {
                answer++;
            }
        }
        return answer;
    }
}