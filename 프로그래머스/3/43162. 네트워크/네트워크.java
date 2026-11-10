import java.util.*;

class Solution {
    static int ntw = 0;
    static int n;
    static int[][] computers;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this. visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i);
                ntw++;
            }
        }
        return ntw;
    }
    
    public static void dfs(int x) {
        visited[x] = true;
        
        for (int i=0; i<n; i++) {
            if (!visited[i] && computers[x][i]==1) {
                dfs(i);
            }
        }
    }
}
/*
그래프 군집 수 구하는 문제
(0,0)~(n-1,n-1)까지 차례로 돌면서 연결되어있는지 확인
*/