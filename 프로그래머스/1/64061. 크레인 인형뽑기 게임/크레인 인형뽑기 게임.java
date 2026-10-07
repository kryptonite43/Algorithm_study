import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
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