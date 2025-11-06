import java.io.*;
import java.util.*;

public class Main2615_1 {
    static int[][] pan = new int[19][19];
    public static boolean check_omok1(int i, int j, int color) {
        // i~i+4, j
        if (i+4>18) return false;
        for (int k=0; k<5; k++) {
            if (pan[i+k][j] != color)
                return false;
        }
        return true;
    }
    public static boolean check_omok2(int i, int j, int color) {
        // i~i+4, j~j-4
        if (i+4>18 || j-4<0) return false;
        for (int k=0; k<5; k++) {
            if (pan[i+k][j-k] != color)
                return false;
        }
        return true;
    }
    public static boolean check_omok3(int i, int j, int color) {
        // i~i+4, j~j+4
        if (i+4>18||j+4>18) return false;
        for (int k=0; k<5; k++) {
            if (pan[i+k][j+k] != color)
                return false;
        }
        return true;
    }
    public static boolean check_omok4(int i, int j, int color) {
        // i, j~j+4
        if (j+4>18) return false;
        for (int k=0; k<5; k++) {
            if (pan[i][j+k] != color)
                return false;
        }
        return true;
    }
    public static boolean checkBorder(int i, int j, int color, int type) {
        int[][] typeArr = {{i-1,j,i+5,j},{i-1,j+1,i+5,j-5},{i-1,j-1,i+5,j+5},{i,j-1,i,j+5}}; // 값이 0~18 사이여야 함
        int[] borders = typeArr[type];
        if (borders[0]>=0 && borders[0]<19 &&borders[1]>=0 && borders[1]<19) { // 범위 안쪽 -> 체크 해야함
            if (pan[borders[0]][borders[1]] == color) { // 육목에 해당함
                return false;
            }
        }
        if (borders[2]>=0 && borders[2]<19 &&borders[3]>=0 && borders[3]<19) { // 범위 안쪽 -> 체크 해야함
            if (pan[borders[2]][borders[3]] == color) { // 육목에 해당함
                return false;
            }
        }
        return true;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean isOmok1, isOmok2, isOmok3, isOmok4;

        for (int i=0; i<19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<19; j++) {
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<19; i++) {
            for (int j=0; j<19; j++) {
                boolean fincheck = false;
                if (pan[i][j] != 0) {
                    isOmok1 = check_omok1(i,j,pan[i][j]);
                    isOmok2 = check_omok2(i,j,pan[i][j]);
                    isOmok3 = check_omok3(i,j,pan[i][j]);
                    isOmok4 = check_omok4(i,j,pan[i][j]);
                    if (isOmok1||isOmok2||isOmok3||isOmok4) {
                        if (isOmok1)
                            fincheck = checkBorder(i,j,pan[i][j],0); // true면 오목완성 맞음 (false면 육목)
                        if (isOmok2)
                            fincheck = checkBorder(i,j,pan[i][j],1);
                        if (isOmok3)
                            fincheck = checkBorder(i,j,pan[i][j],2);
                        if (isOmok4)
                            fincheck = checkBorder(i,j,pan[i][j],3);
                        if (fincheck) {
                            System.out.println(pan[i][j]);
                            if (isOmok2) {
                                i+=4;
                                j-=4;
                            }
                            System.out.println((i+1)+" "+(j+1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws Exception {
        new Main2615_1().solution();
    }
}
