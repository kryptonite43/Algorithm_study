import java.util.*;
import java.io.*;
public class Main2630 {
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    public static void split(int a, int b, int curn) {
        q.addLast(new int[]{a,b,curn});
        q.addLast(new int[]{a,b+curn,curn});
        q.addLast(new int[]{a+curn,b,curn});
        q.addLast(new int[]{a+curn,b+curn,curn});
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        int[] answer = new int[2];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.addLast(new int[]{0,0,n});
        while (!q.isEmpty()) {
            int[] start = q.pollFirst();
            int a = start[0];
            int b = start[1];
            int curn = start[2];
            int color = paper[a][b];
            boolean check = true;
            if (curn == 1) {
                answer[color]++;
                continue;
            }
            for (int i=a; i<a+curn; i++) {
                for (int j=b; j<b+curn; j++) {
                    if (paper[i][j] != color) {
                        check = false;
                        split(a,b,curn/2);
                        i=n;
                        j=n;
                    }
                }
            }
            if (check) {
                answer[color]++;
            }
        }
        System.out.println(answer[0]+"\n"+answer[1]);
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
        new Main2630().solution();
    }
}
