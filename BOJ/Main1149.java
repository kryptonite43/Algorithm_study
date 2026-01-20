import java.util.*;
import java.io.*;
public class Main1149 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] rgb = new int[n][3];
        int[][] cost = new int[n][3]; // i까지의 r시작/g시작/b시작 cost 합

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++)
                rgb[i][j] = Integer.parseInt(st.nextToken());
        }
        cost[0][0] = rgb[0][0];
        cost[0][1] = rgb[0][1];
        cost[0][2] = rgb[0][2];
        //[][0] = red [][1] = green [][2] = blue 가 현재
        for (int i=1; i<n; i++) { // i번째 집
            cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + rgb[i][0];
            cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + rgb[i][1];
            cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + rgb[i][2];

            //System.out.println(Arrays.deepToString(cost));
        }
        System.out.println(Math.min(cost[n-1][0], Math.min(cost[n-1][1], cost[n-1][2])));

        /*
        int pre = -1; // 0,1,2
        for (int i=0; i<3; i++) { // 0=빨강시작 1=초록시작 2=파랑시작
            cost[0][i] = rgb[0][i];
            pre = i;

            // 이전 값이랑만 색 다르면 됨
            // 조건에 맞는 모든 선택을 다 해보는데, 해당 값이 좋으면 계속하고 아니면 튄다
            // 빨강으로 시작하는 경우 / 초록 ~ / 파랑 ~
            // -> 그리디로 풀고 있음. 근데 그리디 아닐 수도 있고 백트래킹 들어가야 돼

            for (int j=1; j<n; j++) { // j번째 집
                int pretmp = -1;
                int tmp = 1001;
                for (int k=0; k<3; k++) {
                    if (pre != k) {
                        if (tmp > rgb[j][k]) { // 값 업데이트
                            pretmp = k;
                            tmp = rgb[j][k];
                        }
                    }
                }
                pre = pretmp;
                cost[j][i] = cost[j-1][i] + tmp;
            }

        }*/

        /* RGB거리 0.5초
         * 집 n개 1번~n번
         * 빨,초,파 중 하나의 색
         * - 1 != 2
         * - n != n-1
         * - i != i-1, i != i+1 (2<=i<=n-1)
         * -> 나란히 두가지 색이 겹치면 안됨
         * >>모든 집을 칠하는 비용의 최솟값 구하기.<<
         *
         * input
         * n (2<=n<=1000)
         * 다음 n개의 줄: 각 집 RGB 칠하는 비용 (비용<=1000)
         *
         * 한 집마다 무슨 색 할지 골라야됨.
         * 색 초이스는 양 옆이랑만 다르면 됨.
         * 집 하나마다 r,g,b 선택  -> 기억 pre post 저장하고 다른 거 선택
         *
         * 3 -> 1 3 1
         * */
    }

    public static void main(String[] args) throws Exception {
        new Main1149().solution();
    }
}
