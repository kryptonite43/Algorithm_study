import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i=0; i<n; i++) { // 행이 n 열이 m
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] checkx = {{0,1,1},{0,0,1},{0,0,1},{0,1,1},{0,0,0},{0,1,2}};
        int[][] checky = {{0,0,1},{0,1,0},{0,1,1},{1,1,0},{0,1,2},{0,0,0}};
        int sum = 0;
        int max = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=0; k<6; k++) { // 다음 6가지 경우에 대해 3개의 값을 더해봄
                    sum = 0;
                    for (int l=0; l<3; l++) {
                        if (i+checkx[k][l]<n && j+checky[k][l]<m)
                            sum += arr[i+checkx[k][l]][j+checky[k][l]];
                        else
                            sum = -10000;
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}