import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점
        m = Integer.parseInt(st.nextToken()); // 간선
        

        int x=0, y=0;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); // 정점
            y = Integer.parseInt(st.nextToken()); // 간선
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        System.out.println(dfs(1, 0));
    }

    public static int dfs(int x, int cnt) {
        visited[x] = true;

        for (int i=1; i<=n; i++) {
            if (arr[x][i]==1 && !visited[i]){
                cnt = dfs(i, cnt+1);
            }
        }
        return cnt;
    }
}