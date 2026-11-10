import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            Integer target = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(target, 0)+" ");
        }
        bw.flush();
    }
}
/*
m, n 최대 10만
원소 최대 10억->int 범위 안, m번 질의하니까 O(1)로 찾아내야 시간내에 가능함
케이스
- 없는 것
- 1개
- 여러 개
- 최대범위
*/