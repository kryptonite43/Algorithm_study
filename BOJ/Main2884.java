import java.io.*;
import java.util.*;
public class Main2884 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        h = (m-45>=0)?h:(h-1>=0)?h-1:h+23;
        m = (m-45>=0)?m-45:m+15;
        System.out.println(h+" "+m);
    }

    public static void main(String[] args) throws Exception {
        new Main2884().solution();
    }
}
