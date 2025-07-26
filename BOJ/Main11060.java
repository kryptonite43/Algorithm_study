import java.util.*;
import java.io.*;

public class Main11060 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] miro = new int[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp, 2000);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=miro[i]; j++) {
                if (i+j<=n) {
                    dp[i+j] = Math.min(dp[i+j], dp[i]+1);
                }
            }
        }
        int answer = dp[n]==2000?-1:dp[n];
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main11060().solution();
    }
}
