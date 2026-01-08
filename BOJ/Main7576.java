import java.io.*;
import java.util.*;
public class Main7576 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] visited = new int[n][m];
        int[][] tomato = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean done = true;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.addLast(new int[]{i,j});
                    visited[i][j] = 1;
                }
                if (tomato[i][j]==0) done=false;
            }
        }
        if (done) {
            System.out.println(0);
            return;
        }
        int day;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        ArrayDeque<int[]> newq = new ArrayDeque<>();
        for (day = 1; ;day++) {
            done = true;
            // 이번 회차에서 토마토 익힘 체크
            while (!q.isEmpty()) {
                int[] cur = q.pollFirst();
                for (int i=0; i<4; i++) {
                    int nextx = cur[0]+dx[i];
                    int nexty = cur[1]+dy[i];
                    if (nextx>=0 && nextx<n && nexty>=0 && nexty<m && visited[nextx][nexty]==0) {
                        visited[nextx][nexty] = 1;
                        if (tomato[nextx][nexty]==0) {
                            tomato[nextx][nexty] = 1;
                            newq.addLast(new int[]{nextx,nexty});
                        }
                    }
                }
            }

            // 이번 회차 변화 체크
            /*//System.out.println("current day: "+day+"\n"+Arrays.deepToString(tomato));
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (tomato[i][j]==0) done = false;
                }
            }
            if (done) {
                System.out.println(day);
                return;
            }*/
            if (newq.isEmpty()) {
                break;
            }
            q = newq;
            newq = new ArrayDeque<>();
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (tomato[i][j]==0) done = false;
            }
        }
        if (done) {
            System.out.println(day-1);
            return;
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        new Main7576().solution();
    }
}
