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

        // 현재 시작점인 범위에서 동전의 개수를 저장하는 배열
        int[][] coins = new int[n][n];
        int sum = 0, max = 0;

        // 부분격자의 시작점 위치: (i,j)
        for (int i=0; i<=n-3; i++) {
            for (int j=0; j<=n-3; j++) {
                sum = 0;

                // i~i+2, j~j+2 의 9개 동전합을 구함
                for (int k=0; k<3; k++) {
                    for (int l=0; l<3; l++) {
                        sum += arr[i+k][j+l];
                    }
                }

                max = Math.max(sum, max);
            }
        }
        
        System.out.println(max);


        /*
        n*n 격자 안에서 3*3 네모에서 동전 들어있는거 최대 구하기
        격자개수 최대 400, 0~n-1까지 좌표 있음
        3*3 만들 수 있는거 시작점: (0,0)~(n-3,n-3)
        부분 격자 이동이면 슬라이딩 윈도우인지 그거 사용할 수 있나? 확인해보기
        예외가 뭐가 있을까? 
        동전이 모든 곳에 하나도 없는 경우, 같은 답이 여러개 나오는 경우
        */
    }
}