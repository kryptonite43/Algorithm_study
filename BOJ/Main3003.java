import java.io.*;
import java.util.*;
public class Main3003 {
    public void solution() throws Exception {
        /*
        킹 1 퀸 1 룩 2 비숍 2 나이트 2 폰 8
        개수 맞추려면 어케해야하는지 보여주기
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] std = {1,1,2,2,2,8};
        int[] found = new int[6];
        for (int i=0; i<6; i++) {
            found[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<6; i++) {
            System.out.print((std[i]-found[i])+ " ");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main3003().solution();
    }
}
