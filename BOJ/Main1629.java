import java.util.*;
import java.io.*;

public class Main1629 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a,b,c));
    }

    public static long pow(long a, long b, long c) {
        if (b == 0)
            return 1;
        long n = pow(a, b/2, c);
        if (b%2==1)
            return (n*n%c) * a % c;
        else
            return n*n%c;
    }
    public static void main(String[] args) throws Exception {
        new Main1629().solution();
    }
}
