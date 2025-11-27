import java.util.*;
import java.io.*;

public class Main11724 {
    static int n, cnt = 0;
    static int[] visited;
    static ArrayList<Integer>[] adj;

    public void solution() throws Exception {
        // ~22분: 문제 파악, dfs/bfs 리마인드, 인접리스트 방식 공부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        visited = new int[n+1];

        for (int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i=0; i<=n; i++) {
            Collections.sort(adj[i]);
        }

        // 탐색 시작
        int startNode = 1;
        while (startNode != -1) {
            dfs(startNode);
            cnt++;
            startNode = allVisitCheck();
        }
        System.out.println(cnt);
    }

    public static void dfs(int x) {
        visited[x] = 1;
        Iterator<Integer> iter = adj[x].listIterator();
        while (iter.hasNext()) {
            int y = iter.next();
            if (visited[y] == 0)
                dfs(y);
        }
    }

    public static int allVisitCheck() {
        for (int i=1; i<=n; i++) {
            if (visited[i] == 0)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Main11724().solution();
    }
}
