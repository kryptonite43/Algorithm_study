import java.util.*;
import java.io.*;
public class Main11022 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=1; i<=t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.printf("Case #%d: %d + %d = %d\n",i,a,b,a+b);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main11022().solution();
    }
}
