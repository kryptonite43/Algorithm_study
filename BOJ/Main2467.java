import java.io.*;
import java.util.*;

public class Main2467 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int high = n-1, low = 0; // 인덱스. int 가능 (최대 10만)
        long cand = 2100000000; // 두 용액의 합 (절댓값 최소) 저장
        int candh=-1, candl=-1;
        while (high > low) { // 두 용액 골라야하므로 high != low 여야 함
            long sum = arr[high] + arr[low];
            if (sum == 0) {
                System.out.println(arr[low] + " " + arr[high]);
                return;
            }
            else {
                if (Math.abs(sum) < cand) {
                    cand = Math.abs(sum);
                    candh = high;
                    candl = low;
                }
                if (sum > 0) high -= 1;
                if (sum < 0) low += 1;
            }
        }
        System.out.println(arr[candl] + " " + arr[candh]);

    }

    public static void main(String[] args) throws Exception {
        new Main2467().solution();
    }
}
