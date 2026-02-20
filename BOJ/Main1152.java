import java.util.*;
import java.util.stream.*;
import java.io.*;

/* BOJ Java 제출 형식 템플릿 */
public class Main1152 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] wordsArr = s.split(" ");
        List<String> words = Arrays.stream(wordsArr).collect(Collectors.toList());
        int cnt = 0;
        for (String c: words) {
            if (!c.equals("")) cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main1152().solution();
    }
}
