import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static boolean[][] visited;
    static int n, cnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j]==1 && !visited[i][j]){ // 방문 안했고 사람임
                    dfs(i,j);
                    list.add(cnt);
                    cnt = 1;
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int a: list) {
            System.out.println(a);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx<0 || nx>=n || ny<0 || ny>=n)
                continue;
            if (arr[nx][ny]==1 && !visited[nx][ny]) {
                cnt++;
                dfs(nx, ny);
            }
        }
    }
}