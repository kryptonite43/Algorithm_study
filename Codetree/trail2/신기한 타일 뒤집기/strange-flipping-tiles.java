import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[200000];
        int cur = 100000;
        int[] color = new int[200000]; // -1이 흑 1이 백

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            switch(d) {
                case 'L':
                    for (int j=cur-x+1; j<=cur; j++) {
                        color[j] = 1;
                    }
                    cur = cur-x+1;
                    break;
                case 'R':
                    for (int j=cur; j<=cur+x-1; j++) {
                        color[j] = -1;
                    }
                    cur = cur+x-1;
                    break;
            }
        }

        int whi = 0, bla = 0;
        for (int i=0; i<200000; i++) {
            switch(color[i]) {
                case -1: bla++; break;
                case 1: whi++; break;
            }
        }

        System.out.println(whi+" "+bla);

        /*
        왼쪽 뒤집으면 흰색 오른쪽 뒤집으면 검은색, 현재 위치 포함
        100칸 1000번 -> 100000. -100000~100000
        100000 더해서 시작, 200000 최대
        5인데 3 L -> 3 4 5, 3 R -> 5 6 7
        */
    }
}