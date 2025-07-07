import java.io.*;
import java.util.*;

public class Main1326 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int[] stones = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            int x = Integer.parseInt(st.nextToken());
            stones[i] = x;
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a==b) {
            System.out.println(0);
            return;
        }

        q.addLast(new int[]{a, 0}); // stones[a] 에서 시작. q에는 {현재 위치, 누적점프횟수}를 집어넣는다
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int curup = cur[0];
            int curdown = cur[0];
            int cnt = cur[1];
            int jump = stones[curup]; // stones[curup] 배수 값만큼 현재 위치에 더해서 q에 집어넣는다

            curup += jump;
            while (curup<=n) {
                if (curup == b) {
                    System.out.println(cnt+1);
                    return;
                }
                q.addLast(new int[]{curup,cnt+1});
                curup += jump;
            }
            curdown -= jump;
            while (curdown>=1) {
                if (curdown == b) {
                    System.out.println(cnt+1);
                    return;
                }
                q.addLast(new int[]{curdown,cnt+1});
                curdown -= jump;
            }
        }
        System.out.println(-1);
        return;
    }

    public static void main(String[] args) throws Exception {
        new Main1326().solution();
    }
}
