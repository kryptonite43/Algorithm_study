import java.util.*;
import java.io.*;

public class Main13335 {
    public void solution() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n==1) {
            // n이 1일 경우 답은 항상 w+1
            System.out.println(w+1);
            return;
        }

        for (int i=0; i<w; i++) {
            q.addLast(0);
        }

        int cnt = 0, sum = 0, index = 0;

        while (!q.isEmpty()) {
            cnt++;
            sum -= q.pollFirst();
            if (index < n) {
                if (arr[index] + sum <= l) {
                    sum += arr[index];
                    q.addLast(arr[index++]);
                }
                else {
                    q.addLast(0);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main13335().solution();
    }
}
