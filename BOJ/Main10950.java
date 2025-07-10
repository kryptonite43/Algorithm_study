import java.util.*;
import java.io.*;

public class Main10950 {
    public void solution() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(a+b));
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main10950().solution();
    }
}
