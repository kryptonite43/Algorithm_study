import java.util.*;
import java.io.*;
public class Main12865 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] knaps = new int[n+1][2];
        int[][] dp = new int[n+1][k+1]; // dp[i][j] = i번 물건까지 판단했을 때 최대무게 j에서 최대 가치

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            knaps[i][0] = Integer.parseInt(st.nextToken()); // wi
            knaps[i][1] = Integer.parseInt(st.nextToken()); // vi
        }

        for (int i=1; i<=n; i++) {
            int wi = knaps[i][0];
            int vi = knaps[i][1];
            for (int w=1; w<=k; w++) {
                if (wi > w) { // 무게 넘침
                    dp[i][w] = dp[i-1][w];
                }
                else {
                    dp[i][w] = Math.max(dp[i-1][w], vi+dp[i-1][w-wi]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }

    public static void main(String[] args) throws Exception {
        new Main12865().solution();
    }
}
