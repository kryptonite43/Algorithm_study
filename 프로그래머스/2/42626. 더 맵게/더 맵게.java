import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순.-> 내림차순은 어떻게 함?
        for (int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (!pq.isEmpty() && pq.peek()<k) {
            if (pq.size()==1)
                return -1;
            int min1 = pq.poll();
            int min2 = pq.poll();
            pq.add(min1+min2*2);
            cnt++;
        }
        
        return cnt;
    }
}
/*
scoville 길이 100만 -> O(n^2) 가 최대임
scoville 원소 100만
k는 10억 -> 2개 합해도 int 범위 안이므로 int 자료형을 사용 가능


항상 min, 2번째로 min 뽑아야함 -> 우선순위 큐를 사용해야함.
min이 k 이상이다 -> 전체가 k 이상이다 (탈출조건)
scoville의 길이가 1로 떨어지면 더이상 합칠 수 없음 유의
*/