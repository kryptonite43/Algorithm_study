import java.util.*;
import java.io.*;

public class Main1764 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> listen = new HashSet<>(n);
        List<String> both = new ArrayList<>();

        for (int i=0; i<n; i++) {
            String name = br.readLine();
            listen.add(name);
        }
        for (int i=0; i<m; i++) {
            String name = br.readLine();
            if (listen.contains(name)) {
                both.add(name);
            }
        }
        Collections.sort(both);
        System.out.println(both.size());
        for (int i=0; i<both.size(); i++) {
            System.out.println(both.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1764().solution();
    }
}
