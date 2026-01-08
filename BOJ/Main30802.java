import java.util.*;
import java.io.*;
public class Main30802 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tshirt = new int[6];

        for (int i=0; i<6; i++) {
            tshirt[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tgr=0, pgr=0, pone=0;
        for (int i=0; i<6; i++) {
            tgr += (tshirt[i]%t==0?tshirt[i]/t:tshirt[i]/t+1);
        }
        pgr = n/p;
        pone = n%p;
        System.out.println(tgr+"\n"+pgr+" "+pone);
    }

    public static void main(String[] args) throws Exception {
        new Main30802().solution();
    }
}
