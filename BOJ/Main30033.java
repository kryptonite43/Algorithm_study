import java.io.*;
import java.util.*;

public class Main30033 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if (a[i]<=b[i]) cnt++;
        }
        System.out.println(cnt);


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
        new Main30033().solution();
    }
}
