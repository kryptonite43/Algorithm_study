import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ Java 제출 형식 템플릿 */
public class Main2525 {
    public static void main(String[] args) throws Exception {
        solution();
    }
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        int chour = c/60;
        int cmin = c%60;

        a += chour;
        b += cmin;
        if (b>=60) a++;
        a %= 24;
        b %= 60;
        System.out.println(a+" "+b);
    }
}
