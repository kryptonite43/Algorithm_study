import java.io.*;
import java.util.*;
public class Main15650 {
    static int[] arr;
    static boolean[] visited;
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        combination(visited, 0, m);
        bw.flush();
    }
    static private void combination(boolean[] visited, int start, int m) throws IOException {
        if (m == 0) {
            for (int i=0; i<n; i++) {
                if (visited[i]) bw.write(arr[i]+" ");
            }
            bw.newLine();
        }

        for (int i=start; i<n; i++) {
            visited[i] = true;
            combination(visited,i+1,m-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main15650().solution();
    }
}
