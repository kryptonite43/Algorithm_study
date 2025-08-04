import java.util.*;
import java.io.*;

public class Main1929 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        for (int i=m; i<=n; i++) {
            if (i==1) continue;
            for (int j=2; j<=Math.sqrt(i); j++) {
                if (i%j == 0) { // 나누어떨어지면 소수가 아니다
                    arr[i] = 1;
                    break;
                }
            }
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1929().solution();
    }
}
