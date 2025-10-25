import java.util.*;
import java.io.*;


public class Main9095_1 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=4; i<11; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        int t = Integer.parseInt(st.nextToken());

        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(dp[n]);
        }


        /* * 3. 출력: System.out.println 대신 BufferedWriter/StringBuilder 사용하기
        * 1) BufferedWriter의 경우
        * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        * bw.write(String.valueOf(data)); // data는 int형
        * bw.newLine();
        * bw.flush();
        * 2)StringBuilder의 경우 (출력해야 할 것들을 모두 모아 sb에 저장 후 sb 출력)
        * StringBuilder sb = new StringBuilder();
        * for (int j=0; j<s; j++){
        *   sb.append(data).append('\n');
        * }
        * System.out.println(sb);
        * */
    }

    public static void main(String[] args) throws Exception {
        new Main9095_1().solution();
    }
}
