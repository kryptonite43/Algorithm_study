import java.util.*;
import java.io.*;
public class Main2468 {
    static int n;
    static int[][] survived, visited;
    static int[] mvx = {0,1,0,-1};
    static int[] mvy = {-1,0,1,0};
    static int answer = 0;

    public void solution() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] area = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Arrays.stream(area).flatMapToInt(Arrays::stream).max().getAsInt();

        for (int i=0; i<=max; i++) {
//            System.out.println(i);
            survived = new int[n+1][n+1]; // 1이 생존, 0이 탈락
            visited = new int[n+1][n+1];

            for (int j=1; j<=n; j++) { // 기준높이 (j이하는 잠긴다)
                for (int k=1; k<=n; k++) {
                    if (area[j][k] > i)
                        survived[j][k] = 1;
                }
            }
//            System.out.println("survived:\n"+Arrays.deepToString(survived));
            int[] cur = allVisitCheck();
            int count = 0;
            while (cur[0]!=-1 && cur[1]!=-1) {
                int x = cur[0];
                int y = cur[1];
                dfs(x,y);
//                System.out.println(Arrays.deepToString(visited));
                cur = allVisitCheck();
                count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = 1;
        for (int i=0; i<4; i++) {
            int nextx = x + mvx[i];
            int nexty = y + mvy[i];
            if (0<nextx && nextx<=n && 0<nexty && nexty<=n && visited[nextx][nexty]==0 && survived[nextx][nexty]==1) {
                dfs(nextx, nexty);
            }
        }
    }
    public static int[] allVisitCheck() {
        for(int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++){
                if (visited[i][j]==0 && survived[i][j]==1) { // 안가보고 생존한 곳이면
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) throws Exception {
        new Main2468().solution();
    }
}
