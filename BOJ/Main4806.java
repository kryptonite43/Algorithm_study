import java.io.*;
public class Main4806 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt=0;
        String str="";
        while ((str=br.readLine())!=null) {
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main4806().solution();
    }
}
