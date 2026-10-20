import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int l=0; l<2; l++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            int size = arr.length;
            int newsize = e-s+1;
            int[] tmp = new int[size-newsize];
            int ind = 0;
            for (int i=0; i<size; i++) {
                if (i>=s-1 && i<=e-1)
                    continue;
                else {
                    tmp[ind++] = arr[i];
                }
            }
            arr = tmp;
        }

        System.out.println(arr.length);
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}