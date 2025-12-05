import java.io.*;

public class Main1003 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] dpzero = new int[45];
        int[] dpone = new int[45];
        dpzero[0] = 1;
        dpzero[1] = 0;
        dpone[0] = 0;
        dpone[1] = 1;
        for (int i=2; i<=40; i++) {
            dpzero[i] = dpzero[i-1]+dpzero[i-2];
            dpone[i] = dpone[i-1]+dpone[i-2];
        }
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = dpzero[n]+" "+dpone[n];
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main1003().solution();
    }
}
