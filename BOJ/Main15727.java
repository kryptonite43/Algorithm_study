import java.io.*;

public class Main15727 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        System.out.println(l%5==0 ? l/5 : l/5+1);
    }

    public static void main(String[] args) throws Exception {
        new Main15727().solution();
    }
}
