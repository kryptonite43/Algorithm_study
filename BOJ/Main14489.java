import java.io.*;
import java.util.*;
public class Main14489 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        int result = (a+b>=2*c)?(a+b-2*c):a+b;
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main14489().solution();
    }
}
