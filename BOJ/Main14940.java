import java.io.*;
import java.util.*;
public class Main14940 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] visited = new int[n][m];
        int[][] ddang = new int[n][m];
        int[] cur;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                ddang[i][j] = Integer.parseInt(st.nextToken());
                if (ddang[i][j]==2) {
                    cur = new int[]{i, j};
                    q.addLast(cur);
                }
            }
        }

        while (!q.isEmpty()) {
            cur = q.pollFirst();
            int curx = cur[0];
            int cury = cur[1];

            for (int k=0; k<4; k++) {
                int nextx = curx + dx[k];
                int nexty = cury + dy[k];
                if (nextx>=0 && nextx<n && nexty>=0 && nexty<m
                        && ddang[nextx][nexty]==1 && visited[nextx][nexty]==0) {
                    q.addLast(new int[]{nextx, nexty});
                    visited[nextx][nexty] = visited[curx][cury]+1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (ddang[i][j]==0) visited[i][j]=0;
                else if (ddang[i][j]==1 && visited[i][j]==0) visited[i][j]=-1;
                bw.write(visited[i][j] +" ");
            }
            bw.newLine();
        }
        bw.flush();
        //System.out.println(Arrays.deepToString(ddang));

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
        new Main14940().solution();
    }
}
