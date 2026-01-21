import java.util.*;
import java.io.*;
public class Main2775 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] apt;
        int k,n;
        for (int a=0; a<t; a++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            apt = new int[k+1][n+1];

            for (int j=1; j<=n; j++) { // 0층 j호
                apt[0][j] = j;
            }

            for (int i=1; i<=k; i++) { // i층
                for (int j=1; j<=n; j++) { // j호
                    if (j==1) {
                        apt[i][j] = apt[i-1][1];
                        continue;
                    }
                    apt[i][j] = apt[i][j-1] + apt[i-1][j];
                }
            }
            System.out.println(apt[k][n]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2775().solution();
    }
}
