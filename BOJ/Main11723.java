import java.util.*;
import java.io.*;

public class Main11723 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int m = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        List<Integer> allSetList = new ArrayList<>();
        for (int i=1; i<=20; i++) {
            allSetList.add(i);
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            }
            else if (cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            }
            else if (cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf((set.contains(x)?1:0)));
                bw.newLine();
            }
            else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x))
                    set.remove(x);
                else
                    set.add(x);
            }
            else if (cmd.equals("all")) {
                set = new HashSet<>(allSetList);
            }
            else if (cmd.equals("empty")) {
                set = new HashSet<>();
            }
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main11723().solution();
    }
}
