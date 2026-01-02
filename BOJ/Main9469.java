import java.io.*;
import java.util.*;

public class Main9469 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int p = Integer.parseInt(br.readLine());
        for (int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double d = Double.parseDouble(st.nextToken());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double f = Double.parseDouble(st.nextToken());

            double answ = (d/(a+b))*f;

            bw.write(n+" "+String.format("%f", answ));
            bw.newLine();
        }
        bw.flush();

    }

    public static void main(String[] args) throws Exception {
        new Main9469().solution();
    }
}
