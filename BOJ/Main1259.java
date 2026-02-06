import java.io.*;
public class Main1259 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder s = new StringBuilder(br.readLine());
        String str = s.toString();
        while (!str.equals("0")) {
            String rev = s.reverse().toString();
            bw.write(str.equals(rev)?"yes":"no");
            bw.newLine();
            s = new StringBuilder(br.readLine());
            str = s.toString();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main1259().solution();
    }
}
