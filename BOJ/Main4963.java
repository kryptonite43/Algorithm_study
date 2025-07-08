import java.io.*;
import java.util.*;

public class Main4963 {
    static int[][] visited;
    static int[][] map;
    static int[] mvx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] mvy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int w = -1, h = -1;

        while (w!=0 && h!=0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0)
                return;
            visited = new int[h][w];
            map = new int[h][w];


            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt;
            for (cnt=0; ; cnt++) {
                int[] cur = allVisitCheck(w,h); // dfs 시작점
                if (cur[0]==-1 && cur[1]==-1)
                    break;
                dfs(cur, w, h);
            }
            System.out.println(cnt);
        }

        /*
        * 2)StringBuilder의 경우 (출력해야 할 것들을 모두 모아 sb에 저장 후 sb 출력)
        * StringBuilder sb = new StringBuilder();
        * for (int j=0; j<s; j++){
        *   sb.append(data).append('\n');
        * }
        * System.out.println(sb);
        * */
    }
    public static int[] allVisitCheck(int w, int h) {
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1)
                    return new int[] {i, j};
            }
        }
        return new int[]{-1,-1};
    }

    public static void dfs(int[] cur, int w, int h) {
        int x = cur[0];
        int y = cur[1];
        visited[x][y] = 1;
        for (int i=0; i<8; i++) {
            int nextx = x+mvx[i];
            int nexty = y+mvy[i];
            if (0<=nextx && nextx<h && 0<=nexty && nexty<w && visited[nextx][nexty]==0 && map[nextx][nexty]==1) {
                dfs(new int[]{nextx, nexty}, w, h);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Main4963().solution();
    }
}
