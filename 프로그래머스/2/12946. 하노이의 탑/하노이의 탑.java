import java.util.*;
import java.util.stream.*;


class Solution {
    ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        int siz = (int)Math.pow(2,n);
        int[][] answer = new int[siz-1][2];
        hanoi(n,1,3,2);
        
        for(int i=0; i<list.size(); i++){
            int[] tmp = list.get(i);
            answer[i][0] = tmp[0];
            answer[i][1] = tmp[1];  
        }
        
        //[[1,3],[1,2],[3,2],[1,3],[2,1],[2,3],[1,3]]
        return answer;
    }
    
    public void hanoi(int n, int from, int to, int via) {
        int[] move = {from, to};
        if (n == 1) {
            list.add(move);
            return;
        }
        hanoi(n-1, from, via, to);
        list.add(move);
        hanoi(n-1, via, to, from);
        
    }
}