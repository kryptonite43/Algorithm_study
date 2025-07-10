import java.io.*;
import java.util.*;

public class Main1008 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());

        System.out.println(a/b);
    }

    public static void main(String[] args) throws Exception {
        new Main1008().solution();
    }
}
