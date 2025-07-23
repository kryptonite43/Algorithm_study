import java.util.*;
import java.io.*;

public class Main25418 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1]; // 해당 index를 만들 수 있는 최소 연산 횟수를 저장하는 배열
        Arrays.fill(dp, 1000000);

        dp[a] = 0;
        for (int i=a; i<=k; i++) {
            if (i+1 <= k)
                dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
            if (i*2 <= k)
                dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
        }
        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws Exception {
        new Main25418().solution();
    }
}
