import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0, cnt = 0;
        for (int i=0; i<n; i++) {
            if (i>=1 && arr[i]>arr[i-1]) {
                cnt++;
            }
            else {
                max = Math.max(cnt, max);
                cnt = 1;
            }
        }
        max = Math.max(cnt, max);

        System.out.println(max);
    }
}