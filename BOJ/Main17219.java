import java.util.*;
import java.io.*;

public class Main17219 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String password = st.nextToken();
            map.put(address, password);
        }

        for (int i=0; i<m; i++) {
            String findpw = br.readLine();
            bw.write(map.get(findpw));
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main17219().solution();
    }
}
