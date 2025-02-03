import java.util.*;

public class Solution15 {

    public static void main(String[] args) {

        //System.out.println(solution(5, 2));
        System.out.println(solution(1, 2));
    }

    private static int solution(int n, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i=1; i<=n; i++) {
            q.addLast(i);
        }

        while (q.size() > 1) {
            for (int i=1; i<=k; i++) {
                int del = q.pollFirst();
                if (i!=k) {
                    q.addLast(del);
                }
            }
        }
        return q.pollFirst();
        /* queue 없이 index % 이용해 풀이
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            arr.add(i);
        }
        int stdind = 0;
        while (arr.size() > 1) {
            int delind = (stdind + k - 1)%arr.size();
            System.out.println("제거: "+ arr.get(delind));
            arr.remove(delind);
            stdind = delind%arr.size();
            System.out.println("std: "+ stdind);
        }
        return arr.get(0);*/
    }
}