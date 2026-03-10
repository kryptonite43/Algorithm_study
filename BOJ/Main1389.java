import java.util.*;
import java.io.*;
public class Main1389 {
    static int[][] rel;
    static int[] kev;
    static int n, m;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rel = new int[n+1][n+1];
        kev = new int[n+1]; // 최종 케빈베이컨수 저장하는 곳

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rel[a][b] = 1;
            rel[b][a] = 1;
        }

        for (int i=1; i<=n; i++) { // 한명씩 bfs로 케빈베이컨수 구하기.
            int[] dist = new int[n+1];
            bfs(i, dist);
            kev[i] = Arrays.stream(dist).sum();
        }

        int ansnum = kev[1];
        int ansuser = 1;
        for (int i=2; i<=n; i++) {
            if (ansnum > kev[i]) {
                ansuser = i;
                ansnum = kev[i];
            }
        }
        System.out.println(ansuser);
    }

    public static void bfs(int start, int[] dist) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.addLast(start);
        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            for (int i=1; i<=n; i++) {
                if (rel[cur][i]==1 && !visited[i]) { // cur과 i가 친구임, 아직 방문안함
                    q.addLast(i);
                    visited[i] = true;
                    dist[i] = dist[cur]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1389().solution();
    }
}
