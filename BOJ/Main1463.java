import java.util.*;
import java.io.*;

public class Main1463 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n==1) {
            System.out.println(0);
            return;
        }
        int[] calc = new int[n+10];
        calc[0] = 0; calc[n] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(n);

        while (calc[1]==0) {
            int curn = q.pollFirst();
            if (curn%3==0 && calc[curn/3]==0) {
                int tmp = curn/3;
                q.addLast(tmp);
                calc[tmp] = calc[curn]+1;
            }
            if (curn%2==0 && calc[curn/2]==0) {
                int tmp = curn/2;
                q.addLast(tmp);
                calc[tmp] = calc[curn]+1;
            }
            if (curn-1>=0 && calc[curn-1]==0) {
                q.addLast(curn-1);
                calc[curn-1] = calc[curn]+1;
            }

            if (calc[1] != 0) {
                System.out.println(calc[1]);
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1463().solution();
    }
}
