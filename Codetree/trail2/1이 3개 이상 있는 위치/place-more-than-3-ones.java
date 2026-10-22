import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int ans = 0; // 1이 적혀 있는 칸의 수가 3개 이상인 칸 개수

        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                // 현재 칸의 상하좌우를 탐방한다.
                int cnt = 0; // 인접 칸 중 1 있는 개수
                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];

                    if (nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]==1) {
                        cnt++;
                    }
                }
                if (cnt>=3) ans++;
            }
        }
        System.out.println(ans);
    }
}
/*
n*n 보드 칸 최대 1만개, 1만개 상하좌우 체크 -> 총 4만개 체크하므로 제한 내에 가능
*/