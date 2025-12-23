import java.io.*;
import java.util.*;

/* BOJ Java 제출 형식 템플릿 */
public class Main2439 {
    public void solution() throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         for (int i=1; i<=n; i++) {
             StringBuilder sb = new StringBuilder();
             for (int j=0; j<n-i; j++) {
                 sb.append(" ");
             }
             for (int j=0; j<i; j++) {
                 sb.append("*");
             }
             System.out.println(sb);
         }

    }

    public static void main(String[] args) throws Exception {
        new Main2439().solution();
    }
}
