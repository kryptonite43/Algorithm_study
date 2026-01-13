import java.io.*;
import java.util.*;

public class Main15650_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;
    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        combination(0, visited, m);
        bw.flush();
    }

    public static void combination(int startIdx, boolean[] visited, int seatLeft) throws IOException {
        if (seatLeft == 0) {
            for (int i=0; i<n; i++) {
                if (visited[i]) bw.write(arr[i]+" ");
            }
            bw.newLine();
            return;
        }
        for (int i=startIdx; i<n; i++) {
            visited[i] = true;
            combination(i+1, visited, seatLeft-1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws Exception {
        new Main15650_1().solution();
    }
}
