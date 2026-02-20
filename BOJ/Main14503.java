import java.util.*;
import java.io.*;
public class Main14503 {
    static int n, m, r, c, d, cleaned = 0;
    static int[][] room;
    static int[][] fdir = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] bdir = {{1,0},{0,-1},{-1,0},{0,1}};

    public void solution() throws Exception {
        /*로봇 청소기 g5 2s/512mb
        * 청소하는 영역의 개수 구하기
        * n*m 방크기, 각 칸은 벽 or 빈칸
        * 청소기: 동서남북 중 하나 바라봄.
        * 방의 각 칸: (r,c)
        * 왼쪽위 0,0 오른쪽아래 n-1,m-1
        * 빈칸-> 전부 청소되지 않은 상태
        *
        * 1. 현재칸 청소
        * 2. 현재칸 상하좌우 체크
        *   2-1. 청소안된칸 있음
        *       반시계 90도 회전 -> 앞쪽 칸 청소 안됐으면 한칸 전진
        *   2-2. 청소안된칸 없음
        *       방향유지, 한칸 후진(가능하면)
        *       작동멈춤(뒤가 벽임, 후진불가)
        * d = 0,1,2,3 // 북동남서
        * 반시계회전 : 동 -> 북 -> 서 -> 남 1 0 3 2 순
        * 22 0  1  2  3
        * 앞 12 23 32 21
        * 뒤 32 21 12 23
        * 각 방향 앞 : -1,0 / 0,1 / 1,0 / 0,-1
        * 각 방향 뒤 : 1,0 / 0,-1 / -1,0 / 0,1
        * int[][] fdir =
         * 1     12
        * 2  21 22 23
        * 3     32
        *
        * input
        * n m (3<=n,m<=50) -> 방 2500 최대
        * 첫좌표 r c 방향 d
        * 다음 n줄: n*m 장소값 (i,j)
        * 0이면 빈칸 1이면 벽
        *
        * output
        * 청소하는 칸의 개수
        *
        * 그냥 시뮬 돌리면 될 듯.. dfs로
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c);
        System.out.println(cleaned);
        // 시작 위치: (r, c)
        // 반시계회전 시 d--. 1 0 3 2 순으로 돈다
        /* 1->0. (d+3)%4
        * 1. 현재칸 청소
         * 2. 현재칸 상하좌우 체크
         *   2-1. 청소안된칸 있음
         *       반시계 90도 회전 -> 앞쪽 칸 청소 안됐으면 한칸 전진
         *   2-2. 청소안된칸 없음
         *       방향유지, 한칸 후진(가능하면)
         *       작동멈춤(뒤가 벽임, 후진불가)
        * */
    }

    public static void dfs(int x, int y) {
        int nx, ny;
        if (room[x][y] == 0) {
            room[x][y]= 2;// 청소됨: 2, 빈칸: 0, 벽: 1
            cleaned++;
        }
        boolean need = false;
        for (int i=0; i<4; i++) {
            nx = x+fdir[i][0];
            ny = y+fdir[i][1];

            if (nx>=0 && nx<n && ny >=0 && ny<m) { // 범위 안쪽이고
                if (room[nx][ny]==0) { // 아직 청소 안됨
                    need = true;
                }
            }
        }
        if (need) {
            d = (d+3)%4; // 반시계 방향 회전
            // 앞쪽 칸
            nx = x + fdir[d][0];
            ny = y + fdir[d][1];
            if (nx>=0 && nx<n && ny >=0 && ny<m) {
                if (room[nx][ny]==0) { // 앞 칸이 청소되지 않은 칸임
                    //System.out.printf("(%d, %d)에서 (%d, %d) 이동: 청소미완\n", x,y,nx,ny);
                    dfs(nx,ny); // 한칸 전진
                }
                else {
                    dfs(x, y);
                }

            }
        }
        else {
            // 4칸 다 청소 되어있다
            nx = x+bdir[d][0];
            ny = y+bdir[d][1];
            if (nx>=0 && nx<n && ny >=0 && ny<m) {
                if (room[nx][ny]!=1) {
                    ///System.out.printf("(%d, %d)에서 (%d, %d) 이동: 청소완\n", x,y,nx,ny);
                    dfs(nx,ny);
                }

                else
                    return;
            }
        }
        //System.out.printf("(%d, %d)에서 완료, cleaned = %d\n", x,y,cleaned);
        //System.out.println(Arrays.deepToString(room));
    }
    // 종이 시뮬부터 하면 됨..

    public static void main(String[] args) throws Exception {
        new Main14503().solution();
    }
}
