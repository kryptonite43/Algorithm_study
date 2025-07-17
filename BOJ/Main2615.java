import java.util.*;
import java.io.*;
public class Main2615 {
    static int[][] arr = new int[21][21];
    public void solution() throws Exception {
        int winner = 0;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=1; i<20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<20; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<20; i++) {
            for (int j=1; j<20; j++) {
                if (arr[i][j] != 0) { // 돌이 있음
                    if (checkHorizontal(i,j) || checkVertical(i,j) || checkDiagonal1(i,j) || checkDiagonal2(i,j)) {
                        winner = arr[i][j];
                        System.out.println(winner+"\n"+i+" "+j);
                        return;
                    }
                }
            }
        }
        System.out.println(winner);
    }
    public static boolean checkHorizontal(int i, int j) { // 가로
        int color = arr[i][j];
        // 가로 5개 연속되었는지 체크.
        for (int a=1; a<5; a++) {
            if ((j+a)>20 || arr[i][j+a] != color) {
                return false;
            }
        }
        // 6개 이상의 경우 체크 i, j는 최대 19
        if (j>15 || arr[i][j-1] == color || arr[i][j+5] == color) {
            return false;
        }
        return true;
    }

    public static boolean checkVertical(int i, int j) { // 세로
        int color = arr[i][j];
        // 세로 5개 연속되었는지 체크
        for (int a=1; a<5; a++) {
            if ((i+a)>20 || arr[i+a][j] != color) {
                return false;
            }
        }
        // 6개 이상의 경우 체크
        if (i>15 || arr[i-1][j] == color || arr[i+5][j] == color) {
            return false;
        }
        return true;
    }

    public static boolean checkDiagonal1(int i, int j) { // 대각선 ↘방향
        int color = arr[i][j];
        // 대각선 5개 연속되었는지 체크
        for (int a=1; a<5; a++) {
            if ((j+a)>20 || (i+a)>20 || arr[i+a][j+a] != color) {
                return false;
            }
        }
        // 6개 이상의 경우 체크
        if (i>15 || j>15 || arr[i-1][j-1] == color || arr[i+5][j+5] == color) {
            return false;
        }
        return true;
    }

    public static boolean checkDiagonal2(int i, int j) { // 대각선 ↙방향
        int color = arr[i][j];
        // 대각선 5개 연속되었는지 체크
        for (int a=1; a<5; a++) {
            if ((j+a)>20 || (i-a)<0 || arr[i-a][j+a] != color) {
                return false;
            }
        }
        // 6개 이상의 경우 체크
        if (i<5 || j>15 || arr[i+1][j-1] == color || arr[i-5][j+5] == color) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main2615().solution();
    }
}