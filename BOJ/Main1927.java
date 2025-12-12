import java.util.*;
import java.io.*;

public class Main1927 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                int ans = minheap.isEmpty() ? 0 : minheap.poll();
                bw.write(String.valueOf(ans));
                bw.newLine();
            }
            else {
                minheap.offer(x);
            }
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main1927().solution();
    }
}
