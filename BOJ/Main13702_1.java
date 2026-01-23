import java.io.*;
import java.util.*;
public class Main13702_1 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] mak = new int[n];

        for (int i=0; i<n; i++) {
            mak[i] = Integer.parseInt(br.readLine());
        }
        long l = 0, x, res=0;
        long r = Integer.MAX_VALUE;
        if (r == 0) { // 막걸리가 모두 용량 0
            System.out.println(0);
            return;
        }

        while (l <= r) {
            long sum = 0;
            x = (l+r)/2; // 현재 체크할 분배 용량
            if (x==0) break;
            for (int i=0; i<n; i++) {
                sum += mak[i]/x;
            }
            if (sum >= k) {
                res = x;
                l = x+1;
            }
            else {
                r = x-1;
            }
        }
        System.out.println(res);


    }

    public static void main(String[] args) throws Exception {
        new Main13702_1().solution();
    }
}
