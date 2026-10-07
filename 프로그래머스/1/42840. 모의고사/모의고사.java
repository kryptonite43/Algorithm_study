import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp1 = {1,2,3,4,5};
        int[] tmp2 = {2,1,2,3,2,4,2,5};
        int[] tmp3 = {3,3,1,1,2,2,4,4,5,5};
        int n = answers.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] res = {0,0,0};
        int cur = -1;

        for (int i=0; i<n; i++) {
            arr1[i] = tmp1[i%5];
            arr2[i] = tmp2[i%8];
            arr3[i] = tmp3[i%10];
        }
        for (int i=0; i<n; i++) {
            if (arr1[i] == answers[i]) res[0]++;
            if (arr2[i] == answers[i]) res[1]++;
            if (arr3[i] == answers[i]) res[2]++;
        }
        // 대소 비교
        int index = 0;
        for (int i=0; i<3; i++) {
            if (cur < res[i]) {
                if (!answer.isEmpty())
                    answer.clear();
                answer.add(i+1);
                cur = res[i];
            }
            else if (cur == res[i]) {
                answer.add(i+1);
                cur = res[i];
            }
        }
        int[] ans = answer.stream().mapToInt(i->i).toArray();
        return ans;
    }
}