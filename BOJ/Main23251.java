import java.io.*;

public class Main23251 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            int k = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(23*k));
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main23251().solution();
    }
}
