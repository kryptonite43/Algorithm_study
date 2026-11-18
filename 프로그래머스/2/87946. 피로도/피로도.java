import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] dungeons;
    static int n, answer=0;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        
        dfs(k, 0); // 현재피로도, 현재 방문개수
        
        return answer;
    }
    
    
    public static void dfs(int curStress, int cnt) {
        answer = Math.max(answer, cnt);
        
        for (int i=0; i<n; i++) {
            if (!visited[i] && dungeons[i][0]<=curStress && curStress-dungeons[i][1]>=0) {
                visited[i] = true;
                dfs(curStress-dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}