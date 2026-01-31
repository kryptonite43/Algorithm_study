import java.io.*;

public class Main1436 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        for (long i=1; n!=0; i++) {
            String num = Long.toString(i);
            if (num.contains("666")) {
                n--;
                ans = i;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main1436().solution();
    }
}
