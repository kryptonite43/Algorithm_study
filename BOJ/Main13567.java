import java.util.*;
import java.io.*;

public class Main13567 {
    public void solution() throws Exception {
        StringTokenizer st;
        int index = 0, x = 0, y = 0;
        int[] movex = new int[]{1,0,-1,0};
        int[] movey = new int[]{0,-1,0,1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("MOVE")) {
                int d = Integer.parseInt(st.nextToken());
                x += d * movex[index]; // 1,0,-1,0
                y += d * movey[index]; // 0,-1,0,1
            }
            else if (cmd.equals("TURN")) {
                int dir = Integer.parseInt(st.nextToken());
                index = (dir == 1 ? (index + 1) % 4 : (index + 3) % 4);
            }
            // 유효성 검사
            if (0>x || x>m || 0>y || y>m) {
                System.out.println(-1);
                return;
            }
            // 동 0 남 1 서 2 북 3
            //System.out.printf("%d번째 명령 후 현재 - 방향: %d, (x,y): (%d, %d)\n",i,index,x,y);
        }

        System.out.println(x+" "+y);
    }

    public static void main(String[] args) throws Exception {
        new Main13567().solution();
    }
}
