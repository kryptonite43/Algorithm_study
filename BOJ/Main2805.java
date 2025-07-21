import java.io.*;
import java.util.*;

public class Main2805 {
    static long[] namu;
    static int n, m;

    public void solution() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        namu = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            namu[i] = Long.parseLong(st.nextToken());
        }
        long max = Arrays.stream(namu).max().getAsLong();
        System.out.println(binarySearch(max, 0));
    }

    public static long binarySearch(long high, long low) {
        long mid;
        long candidate = -1;

        while (high >= low) {
            long cutSum = 0;
            mid = (high+low)/2;

            for (int i=0; i<n; i++) {
                if (namu[i] > mid) {
                    long t = namu[i] - mid;
                    cutSum += t;
                }
            }
            if (cutSum == m) {
                return mid;
            }
            else if (cutSum > m) {
                low = mid + 1;
                candidate = Math.max(candidate, mid);
            }
            else {
                high = mid - 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) throws Exception {
        new Main2805().solution();
    }
}
