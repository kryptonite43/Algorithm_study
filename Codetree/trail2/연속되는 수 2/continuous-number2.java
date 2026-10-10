import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 1;
        int max = 0;
        for (int i=0; i<n; i++) {
            if (i==0 || a[i]!=a[i-1]) {
                max = Math.max(max, cnt);
                cnt = 1;
            }
            else {
                cnt++;
            }
        }
        if (max == 1){
            max = cnt;
        }
        
        System.out.println(max);
    }
}