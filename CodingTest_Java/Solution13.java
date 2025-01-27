import java.util.*;

public class Solution13 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, new int[]{1, 4, 3, 4, 1, 2, 1, 3}));// new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}
    }

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        int[] curtop = new int[n+1];
        Arrays.fill(curtop, -1);
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[j][i] != 0) {
                    curtop[i+1] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(curtop));

        for (int i: moves) {
            if (curtop[i] >= n || curtop[i] == -1) {
                continue;
            }
            int pick = board[curtop[i]][i-1];

            if (!st.isEmpty() && st.peek() == pick) {
                st.pop();
                answer += 2;
            }
            else {
                st.push(pick);
            }
            board[curtop[i]][i-1] = 0;
            curtop[i]++;

        }

        return answer;
    }
}