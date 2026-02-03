import java.io.*;
import java.util.*;
public class Main11660 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] lsum = new int[n+1][n+1];
        int x1,y1,x2,y2;

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j=1; j<=n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                sum += tmp;
                lsum[i][j] = sum;
            }
        }

        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int ans = 0;
            for (int i=x1; i<=x2; i++) {
                int tmp = lsum[i][y2]-lsum[i][y1-1];
                ans += tmp;
            }
            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main11660().solution();
    }
}
