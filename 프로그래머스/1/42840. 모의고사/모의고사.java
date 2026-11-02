import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] stud = new int[][]{
            {1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] winner = new int[3];
        int maxScore = 0;
        for (int n=0; n<3; n++) {
            int[] stu = stud[n];
            int len = stu.length;
            
            int score = 0;
            for (int i=0; i<answers.length; i++) {
                int idx = i%len;
                if (answers[i]==stu[idx]) score++;
            }
            
            if (score>maxScore) {
                winner = new int[]{0,0,0};
                winner[n]=1;
                maxScore = score;
            }
            else if (score == maxScore) {
                winner[n] = 1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<3; i++) {
            if (winner[i]==1) ans.add(i+1);
        }
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}