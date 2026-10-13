import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n];

        for (int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) arr[i] = true;
            else arr[i] = false;
        }

        int cnt = 1, max = 0;
        for (int i=0; i<n; i++) {
            if (i>=1 && arr[i]==arr[i-1]) {
                cnt++;
            }
            else {
                cnt = 1;
            }
            max = Math.max(cnt, max);
        }
        System.out.println(max);
    }
}