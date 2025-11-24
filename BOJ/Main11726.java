import java.io.*;

public class Main11726 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+10];

        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1]%10007)+(dp[i-2]%10007);
        }
        System.out.println(dp[n]%10007);
    }

    public static void main(String[] args) throws Exception {
        new Main11726().solution();
    }
}
