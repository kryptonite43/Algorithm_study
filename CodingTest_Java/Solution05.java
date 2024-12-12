import java.util.Arrays;

public class Solution05 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{2,3,2}, {4,2,4}, {3,1,4}}, new int[][]{{5,4,3}, {2,4,1},{3,1,1}})));
    }
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length;
        int b = arr2.length;
        int c = arr2[0].length;

        int[][] res = new int[a][c];

        for (int i=0; i<a; i++) {
            for (int j=0; j<c; j++) {
                for (int x=0; x<b; x++) {
                    res[i][j] += arr1[i][x] * arr2[x][j];
                }
            }
        }

        return res;
    }
}