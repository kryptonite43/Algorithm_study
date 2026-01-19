import java.io.*;
import java.util.*;
public class Main7576_1 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로

        int[][] visited = new int[n][m];
        int[][] tomato = new int[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        boolean allRiped = true;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.addLast(new int[]{i,j});
                }
                if (tomato[i][j] == 0) allRiped = false;
            }
        }
        if (allRiped) {
            System.out.println(0);
            return;
        }

        int day;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for (day = 0; !q.isEmpty(); day++) {
            ArrayDeque<int[]> newq = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int[] cur = q.pollFirst();
                int x = cur[0]; // ~n
                int y = cur[1]; // ~m
                visited[x][y]=1;

                for (int i=0; i<4; i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if (0<=nx && nx<n && 0<=ny && ny<m) {
                        if (visited[nx][ny]==0 && tomato[nx][ny]==0) { //방문 안된 안익은 토마토 존재
                            tomato[nx][ny]=1;
                            newq.addLast(new int[]{nx,ny});
                        }
                    }
                }
            }
            q = newq;
        }
        // 마지막에 전체 체크: 최대 100만
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day-1);
    }

    public static void main(String[] args) throws Exception {
        new Main7576_1().solution();
    }
}
