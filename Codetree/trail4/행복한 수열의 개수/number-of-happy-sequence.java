import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        // 1. 왼->오 수열 체크
        for (int i=0; i<n; i++) {
            int cnt = 0, tar = arr[i][0];
            for (int j=0; j<n; j++) {
                if (arr[i][j] == tar) {
                    cnt++;
                    if (cnt>=m) {
                        ans++;
                        j=n;
                    }
                }
                else {
                    cnt = 1;
                    tar = arr[i][j];
                }
            }
        }

        // 2. 위->아래 수열 체크
        for (int j=0; j<n; j++) {
            int cnt = 0, tar = arr[0][j];
            for (int i=0; i<n; i++) {
                if (arr[i][j] == tar) {
                    cnt++;
                    if (cnt>=m) {
                        ans++;
                        i=n;
                    }
                }
                else {
                    cnt = 1;
                    tar = arr[i][j];
                }
            }
        }

        System.out.println(ans);
        // Please write your code here.
        /*
n*n 격자, arr[i][j]: 1~100
동일한 원소 m개이상 나오는 구간
1)왼->오
2)위->아래

수열 원소 최대 100개
        */
    }
}