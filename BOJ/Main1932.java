import java.io.*;
import java.util.*;

public class Main1932 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0] = tri[1][0];
        if (n==1) {
            System.out.println(dp[1][0]);
            return;
        }



        for (int i=2; i<=n; i++) {
            for (int j=0; j<i; j++) {
                if (j==0) {
                    dp[i][j] = tri[i][j]+dp[i-1][j];
                }
                else if (j==i-1) {
                    dp[i][j] = tri[i][j]+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = tri[i][j]+Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        int max = Arrays.stream(dp[n]).max().getAsInt();
        System.out.println(max);

    }

    public static void main(String[] args) throws Exception {
        new Main1932().solution();
    }
}
