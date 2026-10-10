import java.util.*;

public class K번째수 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
// [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
    public static int[] solution(int[] array, int[][] commands) {
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

