import java.io.*;
import java.util.*;
public class Main2468_1 {
    static int n, min, max, ans=0;
    static int[][] info, visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        info = new int[n][n];
        visited = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        IntSummaryStatistics stats = Arrays.stream(info).flatMapToInt(Arrays::stream).summaryStatistics();
        min = stats.getMin();
        max = stats.getMax();

        // 기준 높이 x 초과인 게 안전영역
        for (int h=0; h<=max; h++) { // 1~100까지 높이 해보기
            visited = new int[n][n];
            int res = 0;
            int[] cur = allVisitCheck(h);
            while (cur[0]!=-1 && cur[1]!=-1) { // 방문 안한 지점이 있어
                int x = cur[0]; int y = cur[1];
                dfs(h,x,y);
                res++;
                cur = allVisitCheck(h);
            }
            ans = Math.max(ans, res);
        }
        System.out.println(ans);



    }

    public static void dfs(int h, int x, int y) {
        visited[x][y] = 1;
        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny]==0) {
                if (info[nx][ny] > h) {
                    dfs(h,nx,ny);
                }
            }
        }
    }

    public static int[] allVisitCheck(int h) { // 기준에 맞는 방문 안 한 곳이 있는가
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]==0 && info[i][j]>h) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) throws Exception {
        new Main2468_1().solution();
    }
}
