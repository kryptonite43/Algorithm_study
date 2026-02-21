import java.io.*;
public class Main1032 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i=0; i<n; i++) {
            str[i] = br.readLine();
        }
        StringBuilder cmpstr = new StringBuilder(str[0]);
        int len = str[0].length();
        for (int i=0; i<n; i++) {
            for (int j=0; j<len; j++) {
                if (str[i].charAt(j) != cmpstr.toString().charAt(j)) {
                    cmpstr.replace(j,j+1,"?");
                }
            }
        }
        System.out.println(cmpstr);
    }

    public static void main(String[] args) throws Exception {
        new Main1032().solution();
    }
}
