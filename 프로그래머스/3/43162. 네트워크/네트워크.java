import java.util.*;

class Solution {
    static int ntw = 0;
    static int n;
    static int[][] computers;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (computers[i][j]==1) {
                    dfs(i,j);
                    ntw++;
                }
            }
        }
    
        return ntw;
    }
    
    public static void dfs(int x, int y) {
        computers[x][y] = 2;
        computers[y][x] = 2;
        
        for (int i=0; i<n; i++) {
            if (computers[y][i]==1) {
                dfs(y,i);
            }
        }
    }
}
/*
그래프 군집 수 구하는 문제
(0,0)~(n-1,n-1)까지 차례로 돌면서 연결되어있는지 확인
*/