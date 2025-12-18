import java.io.*;
import java.util.*;

public class Main21736 {
    static int n, m;
    static int[][] visited, info;
    static int meet = 0;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new int[n][m];
        info = new int[n][m];
        int[] doyeon = new int[2];
        // 벽 0 빈 공간 1 사람 2
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                switch(s.charAt(j)) {
                    case 'O':
                        info[i][j] = 1;
                        break;
                    case 'X':
                        info[i][j] = 0;
                        break;
                    case 'P':
                        info[i][j] = 2;
                        break;
                    case 'I':
                        doyeon = new int[]{i, j};
                        break;
                }
            }
        }

        dfs(doyeon[0], doyeon[1]);
        if (meet != 0)
            System.out.println(meet);
        else
            System.out.println("TT");
    }
    public static void dfs(int x, int y) {
        visited[x][y] = 1;
        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx>=0 && nx<n && ny>=0 && ny<m && visited[nx][ny]==0) {
                // 벽 0 빈 공간 1 사람 2
                if (info[nx][ny]==1) dfs(nx,ny);
                else if (info[nx][ny]==2) {
                    meet++;
                    dfs(nx,ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main21736().solution();
    }
}
