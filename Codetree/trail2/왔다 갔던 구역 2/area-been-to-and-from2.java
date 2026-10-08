import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 최대 10 L / 10 R 이니까 100 번 명령 한다하면 -1000~1000
        // 1000 더해서 1000에서 시작함. 범위는 2000
        int[] arr = new int[2000];
        Arrays.fill(arr, 0);
        int cur = 1000;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            
            switch (dir) {
                case 'L':
                    for (int j=cur-1; j>=cur-x; j--) {
                        arr[j]++;
                    }
                    cur -= x;
                    break;
                case 'R':
                    for (int j=cur; j<=cur+x-1; j++) {
                        arr[j]++;
                    }
                    cur += x;
                    break;
            }
        }
        System.out.println(Arrays.stream(arr).filter(it -> it>1).count());

    }
    /* 2 3 4 5 6
    시작점을 기준으로 삼음 (영역). x L : 
    현재 위치 5 에서 3 L 이면 왼쪽으로 4 3 2 가잖아 
    그러면 2가 구간인거임 2 3 4 의 구간을 지난거야
    */
}