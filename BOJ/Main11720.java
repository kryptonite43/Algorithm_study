import java.io.*;

public class Main11720 {
    public void solution() throws Exception {
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strarr = br.readLine().split("");
        for (int i=0; i<n; i++) {
            sum += Integer.parseInt(strarr[i]);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main11720().solution();
    }
}
