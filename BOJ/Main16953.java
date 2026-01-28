import java.util.*;
import java.io.*;
public class Main16953 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        System.out.println(calc(a, b, 0));
    }

    public static long calc(long a, long b, long count) {
        if (a == b) {
            return count+1;
        }
        else if (a < b) {
            long cand1 = Long.parseLong(a+"1");
            long cand2 = a*2;
            long i = calc(cand1, b, count+1);
            long j = calc(cand2, b, count+1);
            if (i!=-1||j!=-1) {
                return Math.max(i,j);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main16953().solution();
    }
}
