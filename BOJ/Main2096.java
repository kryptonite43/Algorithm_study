import java.util.*;
import java.io.*;

public class Main2096 {
    public void solution() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n+1][3];
        int[][] dpMax = new int[n+1][3];
        int[][] dpMin = new int[n+1][3];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
            num[i][2] = Integer.parseInt(st.nextToken());
        }

        dpMax[1][0] = dpMin[1][0] = num[1][0];
        dpMax[1][1] = dpMin[1][1] = num[1][1];
        dpMax[1][2] = dpMin[1][2] = num[1][2];


        for (int i=2; i<=n; i++) {
            dpMax[i][0] = Math.max(dpMax[i-1][0],dpMax[i-1][1]) + num[i][0];
            dpMax[i][1] = Math.max(dpMax[i-1][0],Math.max(dpMax[i-1][1],dpMax[i-1][2])) + num[i][1];
            dpMax[i][2] = Math.max(dpMax[i-1][1],dpMax[i-1][2]) + num[i][2];

            dpMin[i][0] = Math.min(dpMin[i-1][0],dpMin[i-1][1]) + num[i][0];
            dpMin[i][1] = Math.min(dpMin[i-1][0],Math.min(dpMin[i-1][1],dpMin[i-1][2])) + num[i][1];
            dpMin[i][2] = Math.min(dpMin[i-1][1],dpMin[i-1][2]) + num[i][2];
        }

        // 마지막 n줄의 3개 수 중 각각 최대 / 최소 출력하면 됨.
        System.out.println(Arrays.stream(dpMax[n]).max().getAsInt()+" "+Arrays.stream(dpMin[n]).min().getAsInt());
    }

    public static void main(String[] args) throws Exception {
        new Main2096().solution();
    }
}
