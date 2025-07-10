import java.io.*;
import java.util.*;


public class Main10026 {
    static int n;
    static int[][] map, visited;
    static int[] mvx = {0, 1, 0, -1};
    static int[] mvy = {-1, 0, 1, 0};

    public void solution() throws Exception {
        int nor = 0, blind = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new int[n][n];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            char[] line = str.toCharArray();
            for (int j=0; j<n; j++) {
                map[i][j] = (line[j] == 'R' ? 0 : (line[j] == 'G' ? 2 : 1));
            }
        }

        // 일반인 체크. 색 순서: R(0) B(1) G(2)
        for (int i=0; i<3; i++) {
            int cur[] = allVisitCheck(i,i);
            int cnt = 0;
            while (cur[0]!=-1 && cur[1]!=-1) {
                int x = cur[0];
                int y = cur[1];

                dfs(x, y, i, i);
                cnt++;
                cur = allVisitCheck(i,i);
            }
            nor += cnt;
            if (i==1) { // B 구역 개수 저장
                blind += cnt;
            }
        }

        visited = new int[n][n];
        // 적록색약 체크. 색 순서: R,G(0,2), B(1)
        int cur[] = allVisitCheck(0,2);
        int cnt = 0;
        while (cur[0]!=-1 && cur[1]!=-1) {
            int x = cur[0];
            int y = cur[1];

            dfs(x, y, 0, 2);
            cnt++;
            cur = allVisitCheck(0,2);
        }
        blind += cnt;

        System.out.println(nor+" "+blind);
    }

    public static int[] allVisitCheck(int checkColor1, int checkColor2) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // 방문 안한 칸이고 현재 탐색하는 색이면
                if (visited[i][j] == 0 && (map[i][j] == checkColor1|| map[i][j] == checkColor2)) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void dfs(int x, int y, int c1, int c2) {
        visited[x][y] = 1;
        for (int i=0; i<4; i++) {
            int nextx = x + mvx[i];
            int nexty = y + mvy[i];
            if (0<=nextx && nextx<n && 0<=nexty && nexty<n
                    && visited[nextx][nexty] == 0 && (map[nextx][nexty] == c1 || map[nextx][nexty] == c2)) {
                dfs(nextx, nexty, c1, c2);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main10026().solution();
    }
}
