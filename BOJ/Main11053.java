import java.io.*;
import java.util.*;
public class Main11053 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lis[i] = 1;
        }
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[i]<arr[j]) {
                    if (lis[j]==1) {
                        lis[j] = lis[i]+1;
                    }
                    else {
                        lis[j] = Math.max(lis[j], lis[i]+1);
                    }
                }
            }
        }
        int ans = Arrays.stream(lis).max().getAsInt();
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main11053().solution();
    }
}
