import java.io.*;

public class Main9095 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int t = Integer.parseInt(br.readLine());
        for (int i=4; i<11; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[n]));
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main9095().solution();
    }
}
