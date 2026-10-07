class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
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