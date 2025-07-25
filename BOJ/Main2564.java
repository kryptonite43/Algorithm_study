import java.util.*;
import java.io.*;

public class Main2564 {
    public void solution() throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> coor = new ArrayList<>();
        ArrayList<Integer> aList = new ArrayList<>();
        int distSum = 0;
        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            aList.add(a);
            switch (a) {
                case 1 -> coor.add(new int[]{0, b});
                case 2 -> coor.add(new int[]{col, b});
                case 3 -> coor.add(new int[]{b, 0});
                case 4 -> coor.add(new int[]{b, row});
            }
        }
        // 동근이 좌표
        int[] tmp = coor.get(n);
        int dongx = tmp[0];
        int dongy = tmp[1];
        int dongA = aList.get(n);
        aList.remove(n);
        coor.remove(n);

        for (int i=0; i<n; i++) {
            int[] store = coor.get(i);
            int curA = aList.get(i);
            int sx = store[0];
            int sy = store[1];
            int round = (col+row)*2;
            int dist;

            if (dongA+curA == 3 || dongA+curA == 7) { // 마주보는 좌표인 경우
                dist = dongx+dongy+sx+sy;
            }
            else {
                dist = Math.abs(dongx-sx) + Math.abs(dongy-sy);
            }
            dist = Math.min(dist, round-dist);
            //System.out.printf("%d번째 상점 거리: %d\n",i,dist);
            distSum += dist;
        }
        System.out.println(distSum);
    }

    public static void main(String[] args) throws Exception {
        new Main2564().solution();
    }
}
