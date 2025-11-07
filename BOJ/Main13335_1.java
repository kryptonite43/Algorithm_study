import java.util.*;
import java.io.*;

public class Main13335_1 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int cursum = 0;
        int idx = 0;
        int count = 0;

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i<w; i++) {
            q.addLast(0);
        }

        while (!q.isEmpty()) {
            cursum -= q.peek();
            q.pollFirst();
            if (idx < n && cursum + trucks[idx] <= l) {
                cursum += trucks[idx];
                q.addLast(trucks[idx]);
                if (idx <= n-1) idx++;
            }
            else {
                if (idx < n)
                    q.addLast(0);
            }
            count++;
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main13335_1().solution();
    }
}
