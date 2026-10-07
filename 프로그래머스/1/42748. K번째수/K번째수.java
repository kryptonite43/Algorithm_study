import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int tc = commands.length;
        int[] answer = new int[tc];
        for (int i=0; i<tc; i++) {
            int ti = commands[i][0]-1;
            int tj = commands[i][1]-1;
            int tk = commands[i][2]-1;
            
            int[] tmparr = new int[tj - ti + 1];
            for (int j=0; j<tmparr.length; j++) {
                tmparr[j] = array[ti+j];
            }
            System.out.println(Arrays.toString(tmparr));
            Arrays.sort(tmparr);
            answer[i] = tmparr[tk];
        }
        return answer;
    }
}