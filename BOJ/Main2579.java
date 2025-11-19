import java.io.*;

public class Main2579 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+2];
        int[] dp = new int[n+2];
        score[0] = 0;
        for (int i=1; i<=n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        switch(n) {
            case 1:
                answer = score[1];
                break;
            case 2:
                answer = score[1]+score[2];
                break;
            case 3:
                answer = Math.max(score[1], score[2]) + score[3];
                break;
        }
        if (n<4) {
            System.out.println(answer);
            return;
        }
        dp[0] = 0;
        dp[1] = score[1];
        dp[2] = score[1]+score[2];
        dp[3] = Math.max(score[1], score[2]) + score[3];

        for (int i=4; i<=n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]+score[i-1]) + score[i];
        }

        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws Exception {
        new Main2579().solution();
    }
}
