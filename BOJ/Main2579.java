import java.util.*;
import java.io.*;

public class Main2579 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];
        int[] dp = new int[n+1];
        List<ArrayDeque<Integer>> eachQ = new ArrayList<>(n+1);
        eachQ.add(new ArrayDeque<>(2));
        for (int i=1; i<=n; i++) {
            score[i] = Integer.parseInt(br.readLine());
            eachQ.add(new ArrayDeque<>(Arrays.asList(0,0)));
        }
        dp[1] = score[1];
        for (int i=1; i<n; i++) {
            if (eachQ.get(i+1).peekLast()!= 0 && eachQ.get(i+1).peekLast()==i-1) { // 값을 업데이트하면 안 되는 경우
                // i-1, i, i+1 3개 연속되면 안 됨
            }
            else {
                int org = dp[i+1];
                dp[i+1] = Math.max(dp[i+1], dp[i]+score[i+1]);
                if (org != dp[i+1]) {
                    eachQ.get(i+1).pollFirst();
                    eachQ.get(i+1).addLast(i);
                }
            }
            if (i==n-1) continue;
            else if (eachQ.get(i+2).peekLast()!= 0 && eachQ.get(i+2).peekLast()==i) { // 값을 업데이트하면 안 되는 경우
                // i-1, i, i+1 3개 연속되면 안 됨
                continue;
            }
            else {
                int org = dp[i+2];
                dp[i+2] = Math.max(dp[i+2], dp[i]+score[i+2]);
                if (org != dp[i+2]) {
                    eachQ.get(i+2).pollFirst();
                    eachQ.get(i+2).addLast(i);
                }
            }
        }
        System.out.println(dp[n]);



        /* 1. 입력을 위한 코드: Scanner 대신 BufferedReader 사용하기
         * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         * int n = Integer.parseInt(br.readLine());
         * ...
         * 2. 공백 기준 String 입력: str.split 대신 StringTokenizer 사용하기
         * StringTokenizer st = new StringTokenizer(br.readLine());
         * int s = Integer.parseInt(st.nextToken());
         * 3. 출력: System.out.println 대신 BufferedWriter/StringBuilder 사용하기
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
        new Main2579().solution();
    }
}
