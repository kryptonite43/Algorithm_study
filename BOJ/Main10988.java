import java.io.*;

public class Main10988 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int l = 0, r = word.length()-1;
        while (l<=r) {
            if (word.charAt(l)!=word.charAt(r)) {
                System.out.println(0);
                return;
            }
            else {
                l++;
                r--;
            }
        }
        System.out.println(1);
    }

    public static void main(String[] args) throws Exception {
        new Main10988().solution();
    }
}
