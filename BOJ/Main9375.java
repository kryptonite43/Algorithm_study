import java.io.*;
import java.util.*;
public class Main9375 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int result = 1;

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String sort = st.nextToken();
                int cnt = map.getOrDefault(sort, 1);
                map.put(sort, cnt+1);
            }

            for (String sort: map.keySet()) {
                int cnt = map.get(sort);
                result *= cnt;
            }
            bw.write(String.valueOf(result-1));
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main9375().solution();
    }
}
