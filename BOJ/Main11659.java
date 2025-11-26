import java.util.*;
import java.io.*;

public class Main11659 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1];
        int[] psum = new int[n+1];
        psum[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            psum[i] = psum[i-1]+num[i];
        }

        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(psum[b] - psum[a-1]));
            bw.newLine();
        }
        bw.flush();






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
        new Main11659().solution();
    }
}
