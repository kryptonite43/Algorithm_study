import java.io.*;
import java.util.*;

public class Main32978 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> ingred = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            ingred.add(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n-1; i++) {
            ingred.remove(st.nextToken());
        }
        Iterator iter = ingred.iterator();
        System.out.println(iter.next());
    }

    public static void main(String[] args) throws Exception {
        new Main32978().solution();
    }
}
