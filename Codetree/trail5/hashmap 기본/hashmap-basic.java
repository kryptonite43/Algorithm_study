import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if (cmd.equals("add")) {
                int v = Integer.parseInt(st.nextToken());
                map.put(k, v);
            }
            else if (cmd.equals("remove")) {
                map.remove(k);
            }
            else if (cmd.equals("find")) {
                Integer ans = map.get(k);
                if (ans==null) bw.write("None\n");
                else bw.write(String.valueOf(ans)+"\n");
            }
        }

        bw.flush();
    }
}
/*
해시맵에서 삽입, 검색, 삭제는 다 O(1)이므로 최대 10만
*/