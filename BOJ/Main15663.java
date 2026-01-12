import java.io.*;
import java.util.*;
public class Main15663 {
    static int n, m;
    static int[] arr, ans;
    static boolean[] visited;
    static LinkedHashSet<String> anspool;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];             // 1 7 9 9
        visited = new boolean[n]; // 0 0 0 0
        ans = new int[m];
        anspool = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(m);

        for (String ansstr: anspool) {
            System.out.println(ansstr);
        }
    }
    private static void permutation(int leftSeat) {
        if (leftSeat == 0) { // 정원 다 찼다
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<m; i++) {
                sb.append(ans[i]).append(" ");
            }
            String ansstr = sb.toString();
            anspool.add(ansstr);
            return;
        }
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            visited[i] = true; // arr[i]를 방문함
            ans[m-leftSeat] = arr[i];
            permutation(leftSeat-1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws Exception {
        new Main15663().solution();
    }
}
