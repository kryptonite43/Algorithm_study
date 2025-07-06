import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* BOJ Java 제출 형식 템플릿 */
public class Main10815 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            set.add(x);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int target = Integer.parseInt(st.nextToken());
            ans.add(set.contains(target)?1:0);
        }
        StringBuilder sb = new StringBuilder(ans.stream().map(Object::toString).collect(Collectors.joining(" ")));
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main10815().solution();
    }
}
