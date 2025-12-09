import java.io.*;
public class Main9461 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[] padovan = new long[110];
        padovan[0] = 0;
        padovan[1] = 1;
        padovan[2] = 1;
        padovan[3] = 1;
        padovan[4] = 2;
        padovan[5] = 2;

        for (int i=6; i<=100; i++) {
            padovan[i] = padovan[i-5]+padovan[i-1];
        }
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(padovan[n]));
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main9461().solution();
    }
}
