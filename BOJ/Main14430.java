import java.util.*;
import java.io.*;

public class Main14430 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int map[][] = new int[n+1][m+1];
        int dp[][] = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (map[i][j]==1) {
                    dp[i][j] += 1;
                }
            }
        }

        int max = Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main14430().solution();
    }
}
