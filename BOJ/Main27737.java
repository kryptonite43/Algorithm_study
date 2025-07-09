import java.io.*;
import java.util.*;

public class Main27737 {
    static int[][] pan, visited;
    static int n, m, k, used = 0;
    static int[] mvx = {0,1,0,-1};
    static int[] mvy = {-1,0,1,0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pan = new int[n][n];
        visited = new int[n][n];


        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (m == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        int[] cur = allVisitCheck();
        while (cur[0]!=-1 && cur[1]!=-1) {
            int x = cur[0];
            int y = cur[1];
            int size = dfs(x,y, 1);
            int turnUse;

            for (turnUse=1; turnUse*k < size; turnUse++) {}
            used += turnUse;

            if (used > m) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            cur = allVisitCheck();
        }
        if (used==0) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println("POSSIBLE");
        System.out.println(m-used);
    }

    public static int[] allVisitCheck() {
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++){
                if (visited[i][j]==0 && pan[i][j]==0) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static int dfs(int x, int y, int size) {
        visited[x][y] = 1;

        for (int i=0; i<4; i++) {
            int nextx = x + mvx[i];
            int nexty = y + mvy[i];
            if (0<=nextx && nextx<n && 0<=nexty && nexty<n && visited[nextx][nexty]==0 && pan[nextx][nexty]==0) {
                size = dfs(nextx, nexty, size+1);
            }
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        new Main27737().solution();
    }
}
