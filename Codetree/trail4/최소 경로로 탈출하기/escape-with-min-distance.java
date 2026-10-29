import java.util.*;
import java.io.*;

public class Main {
    static class Curr {
        int x;
        int y;
        int dist;

        Curr(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static ArrayDeque<Curr> q;
    static int[][] board, dist;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dist = new int[n][m]; // 해당 지점까지의 거리를 저장하는 배열

        q = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        q.addLast(new Curr(0,0,0));
        dist[0][0] = 0;
        bfs();

        System.out.println(dist[n-1][m-1]);
    }

    public static void bfs() {
        while (dist[n-1][m-1]==-1 && !q.isEmpty()) {
            Curr cur = q.pollFirst();

            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx<0 || nx >=n || ny<0 || ny >=m)
                    continue;
                if (dist[nx][ny]==-1 && board[nx][ny]==1) { // 방문안했고 뱀없음
                    q.addLast(new Curr(nx, ny, cur.dist+1));
                    dist[nx][ny] = cur.dist+1;
                }
            }
        }
    }
}
